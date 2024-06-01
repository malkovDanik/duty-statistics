import Vue from 'vue';
import App from './App.vue';
import ElementUI from 'element-ui';
import anychart from 'anychart';
import lang from 'element-ui/lib/locale/lang/ru-RU';
import locale from 'element-ui/lib/locale';
import 'element-ui/lib/theme-chalk/index.css';
// import from 'element-ui/lib/locale/lang/ru-RU';

Vue.config.productionTip = false;

locale.use(lang);
Vue.use(ElementUI);
Vue.use(anychart);
new Vue({
    render: h => h(App),
}).$mount('#app');
