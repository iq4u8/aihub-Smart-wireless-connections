if(window.gzlConstant == undefined) {
    window.gzlConstant = {};
}
if(window.gzlConstant.deviceInfo == undefined){
    window.gzlConstant.deviceInfo = {};
}
if(window.gzlConstant.safeInsets == undefined){
    window.gzlConstant.safeInsets = {};
}
if(window.gzlConstant.systemInfo == undefined){
    window.gzlConstant.systemInfo = {};
}
if(window,gzlConstant.themeInfo == undefined){
    window.gzlConstant.themeInfo = {};
}

if(window.gzlConstant.env == undefined){
    window.gzlConstant.env = {};
}

window.gzlConstant.deviceInfo.platform = '${platform}';
window.gzlConstant.deviceInfo.pixelRatio = ${pixelRatio};

window.gzlConstant.safeInsets.top = ${safeTop};
window.gzlConstant.safeInsets.left = ${safeLeft};
window.gzlConstant.safeInsets.right = ${safeRight};
window.gzlConstant.safeInsets.bottom = ${safeBottom};

window.gzlConstant.systemInfo.language = '${language}';
window.gzlConstant.systemInfo.systemVersion = '${systemVersion}';
window.gzlConstant.systemInfo.brand = '${brand}';
window.gzlConstant.systemInfo.theme = '${theme}';
window.gzlConstant.systemInfo.containerVersion = '${containerVersion}';
window.gzlConstant.systemInfo.appName = '${appName}';
window.gzlConstant.systemInfo.appVersion = '${appVersion}';
window.gzlConstant.systemInfo.appIcon = '${appIcon}';
window.gzlConstant.systemInfo.timeZone = '${timeZone}';
window.gzlConstant.systemInfo.countryCode = '${countryCode}';
window.gzlConstant.systemInfo.regionCode = '${regionCode}';

window.gzlConstant.env.kernel = 'web';
window.gzlConstant.env.mode = '${mode}';


if(window.gzlConstant.pageInfo == undefined){
    window.gzlConstant.pageInfo = {};
}
window.gzlConstant.pageInfo.referrer = '${referrer}'