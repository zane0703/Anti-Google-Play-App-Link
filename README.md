# Anti Google Play App Link

![Alt text](app/src/main/res/drawable-night/ic_app_logo.webp "App Icon")

A specialized Android security utility designed to intercept aggressive advertisement redirects and unauthorized "sideloading" of APK files.
# Motivation

This application was developed out of personal necessity to protect family members specifically my father who frequently encountered aggressive mobile advertisements. These ads often triggered unknown app installations or forced the device to redirect to the Google Play Store without his consent.

By the time I got around to servicing my father’s phone, it was already bombarded with countless pieces of junkware

Many non-tech-savvy users are easily tricked by "tab-under" scripts or deceptive "Your phone is infected" alerts. This app acts as a protective layer to intercept those system calls (Intents) and provide a clear,  warning.

# Key Features
- **Redirect Interception:**  Blocks redirect calls that attempt to move the user from their current app/browser to the Google Play Store.
- **APK Install Guard:** by setting this app as the default app for opening apk be able to block any attempt to sideload
- **Warning message:** there be a warning message show up when the user click the Google play link or open apk file
- **Auto-Close Mode (Advanced):** For tech-savvy users who are simply annoyed by ad redirects, the app can be configured to immediately close itself upon being triggered by a Play Store link instead of showing warning message, effectively "killing" the redirect attempt without requiring user interaction. 
# Downloads (Pre-built Files)
You can download the latest pre-built versions of the application from the Releases section of the repository:
👉 [Download Pre-built Assets](https://github.com/zane0703/Anti-Google-Play-App-Link/releases)

# Configuration Guide (Critical Setup)
To ensure the app correctly intercepts Google Play Store redirects, you must manually change how the Android system handles store links.

1. Disable Google Play Store Link Handling
   1. Go to Settings > Apps > See all apps.
   2. Find and select the Google Play Store.
   3. Tap on Open by default.
   4. Tap Clear default preferences (if active).
   5. Uncheck/Disable Open supported links. This prevents the Play Store from automatically claiming "market://", "play.google.com", "market.android.com" or "my.play" links.

2. Enable Ad & APK Guard Handling
   1. Go to Settings > Apps > See all apps.
   2. Find and select anti play store link.
   3. Tap on Open by default.
   4. Ensure Open supported links is turned ON.
   5. Under Verified links or Supported web addresses, ensure all relevant market and Play Store URLs are checked.
   6. use any apk file or create a fake apk file and then open it the installed devices select this app and click "always"
   7. rename the apk file extension to .xapk then and repaid the above 
   8. install the makeDefault.apk open click the button this will trigger to make the market:// schema as default
   9. you can uninstall the make default app
<br/>


**Note:** once compacted the set up you not be able to access google play via URL link and sideload app there no bypass option unless you clear default for this app you can choose to skip stap 6 and 7 if still want to sideload app
# FAQ
1. **Why the project name called "anti google play app link" but the app itself is called "anti app store link?"**
    - I wanted to named the app "anti google play app link" but it too long to the point that app did not show up in device the app tray as such I had shortened. I it keep the project name just in case poeple thought this tool is for Apple app store instead of Google play
2. **Why block google play app link wasn't google play safe**
   - while Googel activity scan for any malicious app, some malicious app still managed pass through detection and in addition aggressive advertisement may still redirect you to install junkware that not malicious but you will be using it
# Technical Implementation & Limitations

The app functions by registering as a high-priority handler for specific Android Intents:
- Market Links: Intercepts market:// and play.google.com URI schemes.
- Package Installer: Intercepts the application/vnd.android.package-archive MIME type.

**Important Note on Limitations:**
This app works by intercepting web-based and deep-link protocols. It cannot block redirects if an advertisement or malicious app explicitly calls the Google Play Store using its internal Package Name (com.android.vending) via a direct setPackage() Intent call, as these bypass the system's URL-handling selection.

# Disclaimer

This is an unofficial security utility. While it provides a significant layer of protection against accidental installs, the developer is not responsible if a user still manages to install malicious software or if an app bypasses these protections using direct package calls. Users should always remain cautious of the links they click and the permissions they grant.

## Icon used
- [Warning icons created by Good Ware - Flaticon](https://www.flaticon.com/free-icons/warning)
- [External link icons created by Bharat Icons - Flaticon](https://www.flaticon.com/free-icons/external-link)
