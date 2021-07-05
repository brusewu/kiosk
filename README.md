# kiosk
kiosk mode demo

1. open the ADB
2. open command line
4. type "adb devices" you should see the devices that it is connected
5. do command "adb shell dpm set-device-owner com.custom.kioskapp/.kiosk.AdminReceiver"
