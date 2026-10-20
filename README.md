# Android2USB

Local file backup from Android to a USB drive. No ads, account, analytics or Internet permission.

## Download
Open [GitHub Actions](https://github.com/mfarad/Android2USB/actions/workflows/build.yml), select the latest successful build, then download **Android2USB-1.1** under **Artifacts**. Sign in to GitHub to download.

- `Android2USB-test.apk`: signed test build for direct installation.
- `Android2USB-unsigned.aab`: release bundle; sign it with your private upload key before Play submission.
- `Android2USB-source.zip`: source code, bundled font and build wrapper.
- `icon-512.png` and `feature-graphic-1024x500.png`: Play graphics.

The test APK uses a debug certificate. It cannot update the old Copie USB APK signed with another key. Either build with the original private key or uninstall the old app before installation. Uninstalling removes app settings, not the source or USB files. CI debug keys can change between builds. Do not use a debug key for production.

## Features
- Choose English or French on first launch. Change the saved language under Settings.
- Select source and destination through the Android folder picker. The app retains folder access.
- Copy only missing names at the same relative path, including subfolders.
- Existing files are not compared or overwritten. Source files are never deleted.
- File count and progress bar; current file size during a copy.
- Foreground copy notification and stop button.
- XS3 theme, small XS3 wordmark, GitHub link and optional PayPal support button.
- Original adaptive file-to-USB icon.

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

Open the source archive in Android Studio after extraction. The archive includes the wrapper and font.
No signing key or password is stored in this repository.

[Google Play guide (French)](docs/PLAY-STORE-FR.md) · [Privacy policy](docs/privacy.html)

## Brand
Colors and wordmark were read from https://xs3.ch/test/ on 20 October 2026.
Background #080e16; text #e7f4ff; secondary text #9cadc2; blue #46bfff; logo accent #26caff.
The wordmark is native vector artwork based on the site's text logo and arc.
The coffee image is original artwork that links to PayPal; it is not a link to the Buy Me a Coffee service.

## Validation
CI builds the APK and AAB, runs JVM folder/path tests and Android lint.
Physical USB copy, disconnect, reconnect, disk-full and Android 17 runtime checks must be performed on real devices.
