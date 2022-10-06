package me.thealgorithm476.parseua;

public class ParseUA {
    private ParseUA() { throw new IllegalStateException("ParseUA may not be instantiated!"); }

    public static UserAgent parse(String userAgentString) {
        String browser = "Unknown";
        String operatingSystem = "Unknown";
        String browserVersion = "Unknown";
        boolean mobile = false;

        if (userAgentString.contains("Windows")) operatingSystem = "Windows";
        if (userAgentString.contains("Macintosh")) operatingSystem = "macOS";
        if (userAgentString.contains("X11") || userAgentString.contains("Linux")) operatingSystem = "Linux";
        if (userAgentString.contains("CrOS")) operatingSystem = "ChromeOS";
        if (userAgentString.contains("Android")) {
            operatingSystem = "Android";
            mobile = true;
        }
        if (userAgentString.contains("iPhone") || userAgentString.contains("iPad") || userAgentString.contains("iPod")) {
            operatingSystem = "iOS";
            mobile = true;
        }

        if (userAgentString.contains("Firefox")) {
            browser = "Firefox";

            int firefoxVersionIndex = userAgentString.indexOf("Firefox");
            int firefoxVersionEndIndex = userAgentString.indexOf(" ", firefoxVersionIndex);

            if (firefoxVersionEndIndex == -1) firefoxVersionEndIndex = userAgentString.length();

            browserVersion = userAgentString.substring(firefoxVersionIndex + 8, firefoxVersionEndIndex);

            return new UserAgent(browser, operatingSystem, browserVersion, mobile);
        }

        if (userAgentString.contains("FxiOS")) {
            browser = "Firefox";

            int firefoxVersionIndex = userAgentString.indexOf("FxiOS");
            int firefoxVersionEndIndex = userAgentString.indexOf(" ", firefoxVersionIndex);

            if (firefoxVersionEndIndex == -1) firefoxVersionEndIndex = userAgentString.length();

            browserVersion = userAgentString.substring(firefoxVersionIndex + 6, firefoxVersionEndIndex);

            return new UserAgent(browser, operatingSystem, browserVersion, mobile);
        }

        if (userAgentString.contains("CriOS")) {
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

        if (userAgentString.contains("MSIE")) {
            browser = "Internet Explorer";

            int ieVersionIndex = userAgentString.indexOf("MSIE");
            int ieVersionEndIndex = userAgentString.indexOf(";", ieVersionIndex);

            if (ieVersionEndIndex == -1) ieVersionEndIndex = userAgentString.length();

            browserVersion = userAgentString.substring(ieVersionIndex + 5, ieVersionEndIndex);

            return new UserAgent(browser, operatingSystem, browserVersion, mobile);
        }

        if (userAgentString.contains("Trident")) {
            browser = "Internet Explorer";

            int ieVersionIndex = userAgentString.indexOf("rv:");
            int ieVersionEndIndex = userAgentString.indexOf(")", ieVersionIndex);

            if (ieVersionEndIndex == -1) ieVersionEndIndex = userAgentString.length();

            browserVersion = userAgentString.substring(ieVersionIndex + 3, ieVersionEndIndex);

            return new UserAgent(browser, operatingSystem, browserVersion, mobile);
        }

        if (!(userAgentString.contains("Chrome")) && userAgentString.contains("Safari")) {
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

        return new UserAgent(browser, operatingSystem, browserVersion, mobile);
    }
}