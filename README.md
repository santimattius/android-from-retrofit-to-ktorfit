# From Retrofit to Ktorfit on Android

This is basic android project with essential configurations for app develop in android.

## Verification

Run check project:

```shell
> ./gradlew check
```

Run tests project:

```shell
> ./gradlew test
```

## DeteKt

```shell
> ./gradlew :app:detekt
```

## Coverage

Debug:

```shell
> ./gradlew :app:testDebugUnitTestCoverage
```

Release:

```shell
> ./gradlew :app:testReleaseUnitTestCoverage
```
## Dependencies

Below you will find the libraries used to build the template and according to my criteria the most
used in android development so far.

- **[Koin](https://insert-koin.io/)**, dependencies provider.
- **[Retrofit](https://square.github.io/retrofit/)**, networking.
- **[Gson](https://github.com/google/gson)**, json parser.
- **[Coil](https://coil-kt.github.io/coil/compose/)**, with image loader.
- **[Kotlin coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)**.
- **[Mockk](https://mockk.io/)**, testing library.
- **[MockWebServer](https://github.com/square/okhttp/tree/master/mockwebserver)**, networking
  testing library.
