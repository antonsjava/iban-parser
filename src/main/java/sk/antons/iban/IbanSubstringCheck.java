/*
 * Copyright 2025 Anton Straka
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sk.antons.iban;

import java.util.function.IntPredicate;

/**
 *
 * @author antons
 */
public class IbanSubstringCheck {
    IntPredicate check;
    int startPos;
    int endPos;
    String type;
    public IbanSubstringCheck(String type, IntPredicate check, int startPos, int endPos) {
        this.check = check;
        this.startPos = startPos;
        this.endPos = endPos;
        this.type = type;
    }

    public boolean validate(String iban) {
        for(int i = startPos; i < endPos; i++) {
            char c = iban.charAt(i);
            if(!check.test(c)) return false;
        }
        return true;
    }

    public static IbanSubstringCheck numeric(int startPos, int endPos) {
        return new IbanSubstringCheck("0", c -> (('0' <= c) && (c <= '9')), startPos, endPos);
    }

    public static IbanSubstringCheck capitals(int startPos, int endPos) {
        return new IbanSubstringCheck("A", c -> (('A' <= c) && (c <= 'Z')), startPos, endPos);
    }

    public static IbanSubstringCheck letters(int startPos, int endPos) {
        return new IbanSubstringCheck("Aa0", c -> ((('A' <= c) && (c <= 'Z')) || (('a' <= c) && (c <= 'z')) || (('0' <= c) && (c <= '9'))), startPos, endPos);
    }

    @Override
    public String toString() {
        return type+"[" + startPos + "-" + endPos +"]";
    }


}
