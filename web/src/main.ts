import Vue from 'vue';
import App from './App.vue';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
// import from 'element-ui/lib/locale/lang/ru-RU';

Vue.config.productionTip = false;

Vue.use(ElementUI);
new Vue({
    render: h => h(App),
}).$mount('#app');
