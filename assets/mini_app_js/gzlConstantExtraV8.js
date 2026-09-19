if(typeof window == 'undefined'){
    window = globalThis;
}
if(window.gzlConstant == undefined) {
    window.gzlConstant = {};
}
if(window.gzlConstant.appInfo == undefined){
    window.gzlConstant.appInfo = {};
}

window.gzlConstant.appInfo.appId = '${appId}';
window.gzlConstant.appInfo.name = '${name}';
window.gzlConstant.appInfo.icon = '${icon}';
window.gzlConstant.appInfo.version = '${version}';
