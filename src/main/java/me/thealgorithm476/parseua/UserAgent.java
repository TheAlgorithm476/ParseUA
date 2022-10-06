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
 * Class representing a parsed User Agent.
 * <p>
 * It holds information about the Parsed Browser, its version, the Operating System, and whether or not the Operating System is a mobile OS like Android or iOS.
 * @since 1.0
 */
public class UserAgent {
    private final String BROWSER;
    private final String OPERATING_SYSTEM;
    private final String BROWSER_VERSION;
    private final boolean MOBILE;

    /**
     * Creates a new UserAgent object, based on the given parameters.
     * @param browser The browser name.
     * @param operatingSystem The operating system name.
     * @param browserVersion The browser version.
     * @param mobile Whether or not the operating system is a mobile OS.
     * @since 1.0
     */
    public UserAgent(String browser, String operatingSystem, String browserVersion, boolean mobile) {
        this.BROWSER = browser;
        this.OPERATING_SYSTEM = operatingSystem;
        this.BROWSER_VERSION = browserVersion;
        this.MOBILE = mobile;
    }

    /**
     * @return The browser name.
     * @since 1.0
     */
    public String getBrowser() { return BROWSER; }

    /**
     * @return The operating system name.
     * @since 1.0
     */
    public String getOperatingSystem() { return OPERATING_SYSTEM; }

    /**
     * @return The browser version.
     * @since 1.0
     */
    public String getBrowserVersion() { return BROWSER_VERSION; }

    /**
     * @return Whether or not the operating system is a mobile OS.
     * @since 1.0
     */
    public boolean isMobile() { return MOBILE; }

    /**
     * @return A string representation of the UserAgent object, in the format of "Browser: [BROWSERNAME] [BROWSERVERSION], Operating System: [OPERATINGSYSTEMNAME], Mobile: [MOBILE]"
     * @since 1.0
     */
    @Override
    public String toString() { return "Browser: " + BROWSER + " " + BROWSER_VERSION + ", Operating System: " + OPERATING_SYSTEM + ", Mobile: " + MOBILE; }
}