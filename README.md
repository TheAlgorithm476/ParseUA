# ParseUA
Simple static HTTP User Agent parser for Java.

## Usage
```java
import me.thealgorithm476.parseua.ParseUA;
import me.thealgorithm476.parseua.UserAgent;

class Example {
    UserAgent agent = ParseUA.parse("[USER AGENT TO PARSE]");
}
```

The `UserAgent` class contains the following data:
```
browser: String
browserVersion: String
operatingSystem: String
mobile: boolean
```
All fields are accessible through their respective getters.

## Capabilities
ParseUA is capable of parsing all Major Browsers, including:
- Google Chrome
- Mozilla Firefox
- Safari
- Opera
- Microsoft Edge
- Internet Explorer

Other browsers may be able to be parsed, but may not return the correct data. **Chromium-based browsers not listed are known to return Chrome as its UA**.

## Building
Building is simple. Running `./gradlew build` will build the project, and give you a Source JAR as well.  
In case you want a pre-built JAR, you can find all releases on the [OctanDevelopment Maven](https://maven.octandevelopment.com/#/releases), under `me.thealgorithm476:parseua`.

## License
ParseUA is licensed under the MIT License. See [LICENSE](LICENSE) for more information.

## Contributing
Pull requests are very welcome. For major changes, please open an issue first to discuss what you would to see changed. Feel free to fork this repo and tinker around. All help is appreciated.