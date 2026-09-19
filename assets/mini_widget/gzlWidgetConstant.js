if(typeof window == 'undefined'){
    window = globalThis;
}
if(window.gzlConstant == undefined) {
    window.gzlConstant = {};
}
if(window.gzlConstant.deviceInfo == undefined){
    window.gzlConstant.deviceInfo = {};
}

if(window.gzlConstant.systemInfo == undefined){
    window.gzlConstant.systemInfo = {};
}

if(window.gzlConstant.env == undefined){
    window.gzlConstant.env = {};
}

window.gzlConstant.deviceInfo.platform = '${platform}';
window.gzlConstant.deviceInfo.screenWidth = ${screenWidth};
window.gzlConstant.deviceInfo.screenHeight = ${screenHeight};
window.gzlConstant.deviceInfo.viewWidth = ${viewWidth};
window.gzlConstant.deviceInfo.viewHeight = ${viewHeight};
window.gzlConstant.deviceInfo.pixelRatio = ${pixelRatio};
window.gzlConstant.deviceInfo.orientation = '${orientation}';

window.gzlConstant.systemInfo.language = '${language}';
window.gzlConstant.systemInfo.systemVersion = '${systemVersion}';
window.gzlConstant.systemInfo.brand = '${brand}';
window.gzlConstant.systemInfo.appVersion = '${appVersion}';
window.gzlConstant.systemInfo.theme = '${theme}';
window.gzlConstant.systemInfo.containerVersion = '${containerVersion}';
window.gzlConstant.systemInfo.timeZone = '${timeZone}';
window.gzlConstant.systemInfo.countryCode = '${countryCode}';

window.gzlConstant.deviceInfo.deviceId = '${deviceId}';

window.gzlConstant.env.mode = '${mode}';
