# Spring Filter Ordering example

Example for youtube video: [Spring Filters Series 5 - Order of Filters in Spring](https://youtu.be/5poQ0n6-mvs)

## Explanation
This repo contains examples of 3 different ways how to set order of filters in Spring:

- `DoNothingFilter` is instantiated via `FilterRegistrationBean` which is placed inside `MyAppConfiguration`. It has `HIGHEST_PRECEDENCE` which is equivalent of `Integer.MIN_VALUE` therefore it goes first.
- `MyCustomHeaderFilter` goes after `DoNothingFilter` since its order is set to `HIGHEST_PRECEDENCE + 1` value. It uses `@Order` annotation to set the order value.
- `HeadersLoggingFilter` goes last since its order set to `LOWEST_PRECEDENCE`. This example uses `Ordered` interface.


## Testing locally

- Run the application
- Send `GET` request to root path:
  - httpie: `http :8080`
  - curl: `curl http://localhost:8080`
- Observe logging

## Following the video

If you want to dig deeper, you can find `ApplicationFilterChain.java` class (`shift+cmd+o` mac, `Ctrl+Shift+T` windows), set a breakpoint on the line `167` where the loop starts, very first line of the `internalDoFilter` method and inspect filters there. 

Please note, you may see the following order:

- `DoNothingFilter`
- `OrderedCharacterEncodingFilter`
- `MyCustomHeaderFilter`
- ....

The `CharacterEncodingFilter` also has `HIGHEST_PRECEDENCE` value, that's why it goes before `MyCustomHeaderFilter`

