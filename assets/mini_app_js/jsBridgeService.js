if(typeof window == 'undefined'){
    window = globalThis;
}
if (window.gzlJSBridge == undefined) {
    window.gzlJSBridge = {};
}
if (window.gzlJSBridge.appChannel == undefined) {
    window.gzlJSBridge.appChannel = {};
}

window.__webviewId__ = '100';

function __serviceInvoke__(webViewId, args, callback) {
    gzlServiceNativeBridge.serviceInvoke(webViewId, args, callback);
}
window.gzlJSBridge.serviceInvoke = __serviceInvoke__;

function __setEventChannel__(callback) {
    gzlServiceNativeBridge.setEventChannel(callback);
}
window.gzlJSBridge.eventChannel = __setEventChannel__;

function __setGlobalGZLEventHandler__(callback) {
    gzlServiceNativeBridge.setGlobalGZLEventHandler(callback);
}
window.setGlobalGZLEventHandler = __setGlobalGZLEventHandler__;

function __onServiceLoaded__() {
    gzlServiceNativeBridge.onServiceLoaded();
}
window.__SERVICE_LOADED__ = __onServiceLoaded__;

function __reportError__(type, message, stack) {
    gzlServiceNativeBridge.reportError(type, message, stack);
}
window.gzlJSBridge.reportError = __reportError__;

function __serviceInvokeNative__(webviewId, action, data) {
    gzlServiceNativeBridge.serviceInvokeNative(webviewId, action, data);
}
window.gzlJSBridge.serviceInvokeNative = __serviceInvokeNative__;

function setTimeout(callback, delay) {
    if (callback === undefined || callback === null) {
      return -1;
    }
    if (delay === undefined || delay === null) {
      delay = 0;
    }
    for (var _len = arguments.length, params = new Array(_len > 2 ? _len - 2 : 0), _key = 2; _key < _len; _key++) {
      params[_key - 2] = arguments[_key];
    }
    return gzlServiceNativeBridge.setTimeout.apply(gzlServiceNativeBridge, [callback, parseInt(delay)].concat(params));
  }

function clearTimeout(id) {
    if(id === undefined || id === null) {
        gzlServiceNativeBridge.clearTimeout(-1);
    }else {
        gzlServiceNativeBridge.clearTimeout(id);
    }
}

function setInterval(callback, delay) {
    if (callback === undefined || callback === null) {
        return -1;
      }
      if (delay === undefined || delay === null) {
        delay = 0;
      }
      for (var _len = arguments.length, params = new Array(_len > 2 ? _len - 2 : 0), _key = 2; _key < _len; _key++) {
        params[_key - 2] = arguments[_key];
      }
      return gzlServiceNativeBridge.setInterval.apply(gzlServiceNativeBridge, [callback, parseInt(delay)].concat(params));
}

function clearInterval(id) {
    if(id === undefined || id === null) {
        gzlServiceNativeBridge.clearInterval(-1);
    }else {
        gzlServiceNativeBridge.clearInterval(id);
    }
}

function __gzlCall__(module, method, params, success, fail) {
    if (method.endsWith('Sync')) {
      const res = gzlServiceNativeBridge.callNativeSync(module, method, params);
      return res;
    }
    const successFunc = success;
    const failFunc = fail;
    return new Promise((resolve, reject) => {
      gzlServiceNativeBridge.callNativeAsync(module, method, params, {
        success: function (res) {
          if (successFunc && typeof successFunc === 'function') {
              successFunc(res);
          }
          resolve(res);
        },
        fail: function (res) {
            if (failFunc && typeof failFunc === 'function'){
                failFunc(res);
            }
            resolve(res);
        },
      });
    });
}
window.gzlJSBridge.call = __gzlCall__;

function __callRNApiReturnPromise__(options, ...params) {
  return new Promise((resolve, reject) => {
    gzlServiceNativeBridge.callRNApi(options, {
      success: function (res) {
        resolve(__parseJSStr(res));
      },
      fail: function (res) {
        reject(__parseJSStr(res));
      },
      }, params);
  });
}
window.gzlJSBridge.callRNApiReturnPromise = __callRNApiReturnPromise__;

function __parseJSStr(res) {
    if (typeof res === "string") {
        let result = JSON.parse(res)
        if (Array.isArray(result)) {
            result = result[0]
        }
        console.log("__parseJSStr", JSON.stringify(result));
        return result
    }
    return res
}

function __callRNApi__(options, ...params) {
  return gzlServiceNativeBridge.callRNApi(options, {}, params);
}
window.gzlJSBridge.callRNApi = __callRNApi__;

function __addRNListener__(options, callback) {
      if(options === null || options === undefined) {
          return null;
      }
      const callbackId = gzlServiceNativeBridge.addRNListener(options, callback);
      options["callbackId"] = callbackId
      return {
        remove: function() {
            gzlServiceNativeBridge.removeRNListener(options);
        }
      }
}
window.gzlJSBridge.addRNListener = __addRNListener__;

window.__gzlServiceHandlerBack__ = (pageId, callbackId) => {
    if (callbackId === undefined || callbackId === null || pageId === null || pageId === undefined) {
        return null;
    }
    return (args)=> {
        gzlServiceNativeBridge.serviceHandlerMethodCallback(pageId, callbackId, args);
    };
}

function __postMessage__(type, data) {
    if(type === null || type === undefined) {
        type = '';
    }
    if(data === null || data === undefined) {
        data = '';
    }

    gzlServiceNativeBridge.postMessage(type, JSON.stringify(data));
}
window.gzlJSBridge.appChannel.postMessage = __postMessage__;

function __onMessage__(callback) {
    gzlServiceNativeBridge.onMessage(function __callback__(data){
        callback(JSON.parse(data));
    });
}
window.gzlJSBridge.appChannel.onMessage = __onMessage__;