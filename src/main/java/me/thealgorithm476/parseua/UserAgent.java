package me.thealgorithm476.parseua;

public class UserAgent {
    private final String BROWSER;
    private final String OPERATING_SYSTEM;
    private final String BROWSER_VERSION;
    private final boolean MOBILE;

    public UserAgent(String browser, String operatingSystem, String browserVersion, boolean mobile) {
        this.BROWSER = browser;
        this.OPERATING_SYSTEM = operatingSystem;
        this.BROWSER_VERSION = browserVersion;
        this.MOBILE = mobile;
    }

    public String getBrowser() { return BROWSER; }

    public String getOperatingSystem() { return OPERATING_SYSTEM; }

    public String getBrowserVersion() { return BROWSER_VERSION; }

    public boolean isMobile() { return MOBILE; }

    @Override
    public String toString() { return "Browser: " + BROWSER + " " + BROWSER_VERSION + ", Operating System: " + OPERATING_SYSTEM + ", Mobile: " + MOBILE; }
}