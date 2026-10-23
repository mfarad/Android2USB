# Android2USB

Local file backup from Android to a USB drive. No ads, account, analytics or Internet permission.

## Download
Open [GitHub Actions](https://github.com/mfarad/Android2USB/actions/workflows/build.yml), select the latest successful build, then download **Android2USB-1.5** under **Artifacts**. Sign in to GitHub to download.

- `Android2USB-test.apk`: signed test build for direct installation.
- `Android2USB-unsigned.aab`: release bundle; sign it with your private upload key before Play submission.
- `Android2USB-source.zip`: source code, bundled font and build wrapper.
- `icon-512.png` and `feature-graphic-1024x500.png`: Play graphics.


## USB notes
The drive must be recognized by Android. If Android prevents selection of the root, create a Photos folder and select it.
The provider must support writing and renaming. Temporary files are renamed only after byte-count checks.
The app stops at the first error. Completed files remain. Reconnect the same drive after an interrupted copy.
The next run attempts to remove only its recorded unfinished temporary file.
Existing files are identified by name and relative path, not by content hash.

## Build
JDK 17, Gradle 8.13, Android SDK 36. Compile SDK 36, target SDK 37, minimum Android 8.
The target is Android 17; Android 17 and physical USB device testing are still required before public release.
The bundled font is Space Grotesk under SIL OFL. It is retrieved during asset preparation; the app itself has no network access.

```sh
python3 -m pip install Pillow
python3 tools/prepare_assets.py
gradle wrapper --gradle-version 8.13
./gradlew testDebugUnitTest lintDebug assembleDebug bundleRelease
```


## Validation
CI builds the APK and AAB, runs JVM folder/path tests and Android lint.
Physical USB copy, disconnect, reconnect, disk-full and Android 17 runtime checks must be performed on real devices.
