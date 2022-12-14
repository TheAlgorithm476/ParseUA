/*
 * Copyright (c) 2022, TheAlgorithm476
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package me.thealgorithm476.parseua;

/**
 * Main ParseUA class. Holds the parse method.
 * @since 1.0
 */
public class ParseUA {
    private ParseUA() { throw new IllegalStateException("ParseUA may not be instantiated!"); }

    /**
     * Parses the given User Agent String, and returns a {@link UserAgent} object.
     * @param userAgentString The User Agent String to parse.
     * @return A {@link UserAgent} object wrapping the parsed User Agent String.
     * @since 1.0
     */
    public static UserAgent parse(String userAgentString) {
        String browser = "Unknown";
        String operatingSystem = "Unknown";
        String browserVersion = "Unknown";
        boolean mobile = false; // Most platforms are not mobile by default, so this is a good default value, in case parsing fails.

        if (userAgentString == null) return new UserAgent(browser, operatingSystem, browserVersion, mobile); // Just return if null

        // ---- Operating System ----
        if (userAgentString.contains("Windows")) operatingSystem = "Windows";
        if (userAgentString.contains("Macintosh")) operatingSystem = "macOS";
        if (userAgentString.contains("X11") || userAgentString.contains("Linux")) operatingSystem = "Linux"; // X11 is the most-used Window Server on Linux, and many UAs include it.
        if (userAgentString.contains("CrOS")) operatingSystem = "ChromeOS"; // CrOS is the abbreviation for Chrome OS in its User Agent String.
        if (userAgentString.contains("Android")) {
            operatingSystem = "Android";
            mobile = true;
        }
        if (userAgentString.contains("iPhone") || userAgentString.contains("iPad") || userAgentString.contains("iPod")) {
            operatingSystem = "iOS";
            mobile = true;
        }

        // ---- Browser ----
        if (userAgentString.contains("Firefox")) {
            browser = "Firefox";

            int firefoxVersionIndex = userAgentString.indexOf("Firefox");
            int firefoxVersionEndIndex = userAgentString.indexOf(" ", firefoxVersionIndex);

            if (firefoxVersionEndIndex == -1) firefoxVersionEndIndex = userAgentString.length();

            browserVersion = userAgentString.substring(firefoxVersionIndex + 8, firefoxVersionEndIndex);

            return new UserAgent(browser, operatingSystem, browserVersion, mobile);
        }

        if (userAgentString.contains("FxiOS")) { // Firefox on iOS
            browser = "Firefox";

            int firefoxVersionIndex = userAgentString.indexOf("FxiOS");
            int firefoxVersionEndIndex = userAgentString.indexOf(" ", firefoxVersionIndex);

            if (firefoxVersionEndIndex == -1) firefoxVersionEndIndex = userAgentString.length();

            browserVersion = userAgentString.substring(firefoxVersionIndex + 6, firefoxVersionEndIndex);

            return new UserAgent(browser, operatingSystem, browserVersion, mobile);
        }

        if (userAgentString.contains("CriOS")) { // Chrome on iOS
            browser = "Google Chrome";

            int chromeVersionIndex = userAgentString.indexOf("CriOS");
            int chromeVersionEndIndex = userAgentString.indexOf(" ", chromeVersionIndex);

            if (chromeVersionEndIndex == -1) chromeVersionEndIndex = userAgentString.length();

            browserVersion = userAgentString.substring(chromeVersionIndex + 6, chromeVersionEndIndex);

            return new UserAgent(browser, operatingSystem, browserVersion, mobile);
        }

        if (userAgentString.contains("Opera") || userAgentString.contains("OPR")) {
            browser = "Opera";

            int operaVersionIndex = userAgentString.indexOf("OPR");
            if (operaVersionIndex == -1) operaVersionIndex = userAgentString.indexOf("Opera");
            int operaVersionEndIndex = userAgentString.indexOf(" ", operaVersionIndex);

            if (operaVersionEndIndex == -1) operaVersionEndIndex = userAgentString.length();

            browserVersion = userAgentString.substring(operaVersionIndex + 4, operaVersionEndIndex);

            return new UserAgent(browser, operatingSystem, browserVersion, mobile);
        }

        if (userAgentString.contains("Edg")) {
            browser = "Microsoft Edge";

            int edgeVersionIndex = userAgentString.indexOf("Edg");
            int edgeVersionEndIndex = userAgentString.indexOf(" ", edgeVersionIndex);

            if (edgeVersionEndIndex == -1) edgeVersionEndIndex = userAgentString.length();

            browserVersion = userAgentString.substring(edgeVersionIndex + 4, edgeVersionEndIndex);

            return new UserAgent(browser, operatingSystem, browserVersion, mobile);
        }

        if (userAgentString.contains("MSIE")) { // "Old" IE
            browser = "Internet Explorer";

            int ieVersionIndex = userAgentString.indexOf("MSIE");
            int ieVersionEndIndex = userAgentString.indexOf(";", ieVersionIndex);

            if (ieVersionEndIndex == -1) ieVersionEndIndex = userAgentString.length();

            browserVersion = userAgentString.substring(ieVersionIndex + 5, ieVersionEndIndex);

            return new UserAgent(browser, operatingSystem, browserVersion, mobile);
        }

        if (userAgentString.contains("Trident")) { // "New" IE
            browser = "Internet Explorer";

            int ieVersionIndex = userAgentString.indexOf("rv:");
            int ieVersionEndIndex = userAgentString.indexOf(")", ieVersionIndex);

            if (ieVersionEndIndex == -1) ieVersionEndIndex = userAgentString.length();

            browserVersion = userAgentString.substring(ieVersionIndex + 3, ieVersionEndIndex);

            return new UserAgent(browser, operatingSystem, browserVersion, mobile);
        }

        if (!(userAgentString.contains("Chrome")) && userAgentString.contains("Safari")) { // The Chrome UA by default also includes a Safari identifier, but Safari strings do not include a Chrome one, so we explicitly check for the absence of Chrome.
            browser = "Safari";

            int safariVersionIndex = userAgentString.indexOf("Version");
            int safariVersionEndIndex = userAgentString.indexOf(" ", safariVersionIndex);

            if (safariVersionEndIndex == -1) safariVersionEndIndex = userAgentString.length();

            browserVersion = userAgentString.substring(safariVersionIndex + 8, safariVersionEndIndex);

            return new UserAgent(browser, operatingSystem, browserVersion, mobile);
        }

        if (userAgentString.contains("Chrome")) {
            browser = "Google Chrome";

            int chromeVersionIndex = userAgentString.indexOf("Chrome");
            int chromeVersionEndIndex = userAgentString.indexOf(" ", chromeVersionIndex);

            if (chromeVersionEndIndex == -1) chromeVersionEndIndex = userAgentString.length();

            browserVersion = userAgentString.substring(chromeVersionIndex + 7, chromeVersionEndIndex);

            return new UserAgent(browser, operatingSystem, browserVersion, mobile);
        }

        return new UserAgent(browser, operatingSystem, browserVersion, mobile); // Return our defaults if we can't parse the UA.
    }
}