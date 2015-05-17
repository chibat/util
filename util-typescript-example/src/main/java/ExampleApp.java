/*
 * Copyright 2015- Tomofumi Chiba
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import io.github.chibat.selva.App;
import io.github.chibat.selva.server.Server;
import io.github.chibat.util.typescript.EntityCodeGenerator;

/**
 * 
 * @author tomofumi
 */
public class ExampleApp implements App {

    @Override
    public void init() {

        resource("/").get(req -> forward("/calc.html"));

        resource("/calc").get(req -> {
            Input input = req.bean(Input.class);
            Result result = new Result();
            result.add = input.arg1 + input.arg2;
            result.subtract = input.arg1 - input.arg2;
            return json(result);
        });

    }

    public static class Input {
        public Integer arg1;
        public Integer arg2;
    }

    public static class Result {
        public Integer add;
        public Integer subtract;
    }

    public static void main(String[] args) {
        new EntityCodeGenerator().readClass(Input.class, Result.class).writeFile(
            "src/main/typescript/entities.ts"); // (1)

        new Server().add(ExampleApp.class).listen(); // (2)
    }
}
