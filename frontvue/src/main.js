// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue';
import App from './App';
import router from './router';
import store from './store';
import VueResource from 'vue-resource';

var ISDEV = (process.env.NODE_ENV === 'development');

var isLocalhost = Boolean(window.location.hostname === 'localhost' ||
  window.location.hostname === '[::1]' ||
  window.location.hostname.match(
    /^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/
  )
)

Vue.config.productionTip = false;

Vue.use(VueResource);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: { App }
})

if ('serviceWorker' in navigator &&
  (window.location.protocol === 'https:' || isLocalhost)) {
  if (!ISDEV) {
    navigator.serviceWorker.register('service-worker.js')
  }
}

