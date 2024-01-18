#### Run Tests

To execute the tests, use the following Maven command:

`mvn test -P <profile> -D browser=<browser>`


### Options

- **Profiles:**
  - `ErrorValidationCreateAccount`: Run tests for the ErrorValidationCreateAccount profile.
  - `Purchase`: Run tests for the Purchase profile.
  - `CompleteRegression`: Run tests for the CompleteRegression profile.


- **Browsers:**
  - `chrome`: Run tests using the Chrome browser.
  - `firefox`: Run tests using the Firefox browser.
  - `edge`: Run tests using the Edge browser.
	