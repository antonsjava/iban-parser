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

/**
 *
 * @author antons
 */
public interface IbanSubstringResolver {

    String resolve(String iban);

    public static class None implements IbanSubstringResolver {

        @Override
        public String resolve(String iban) {
            return null;
        }

        public static None instance() { return new None(); }

        @Override
        public String toString() {
            return "None{" + '}';
        }

    }

    public static class Substring implements IbanSubstringResolver {

        int startPos;
        int endPos;

        @Override
        public String resolve(String iban) {
            return iban.substring(startPos, endPos);
        }

        public Substring(int startPos, int endPos) {
            this.startPos = startPos;
            this.endPos = endPos;
        }
        public static Substring instance(int startPos, int endPos) { return new Substring(startPos, endPos); }

        @Override
        public String toString() {
            return "Substring{" + "startPos=" + startPos + ", endPos=" + endPos + '}';
        }


    }

    public static class Pattern implements IbanSubstringResolver {

        char c;
        String pattern;

        @Override
        public String resolve(String iban) {
            StringBuilder sb = new StringBuilder();
            int len = pattern.length();
            for(int i = 0; i < len; i++) {
                char cc = pattern.charAt(i);
                if(c != cc) continue;
                char ccc = iban.charAt(i);
                sb.append(ccc);
            }
            return sb.length() == 0 ? null : sb.toString();
        }

        public Pattern(char c, String pattern) {
            this.c = c;
            this.pattern = pattern;
        }
        public static Pattern instance(char c, String pattern) { return new Pattern(c, pattern); }

        @Override
        public String toString() {
            return "Pattern{" + "c=" + c + ", pattern=" + pattern + '}';
        }

    }

}
