var css = document.createElement('style');
css.type = 'text/css';
if (css.styleSheet) {
    css.styleSheet.cssText = '${nativeStyles}';
}else {
    css.appendChild(document.createTextNode('${nativeStyles}'));
}
document.getElementsByTagName('head')[0].appendChild(css);