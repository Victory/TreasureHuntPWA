import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import About from '@/components/About'
import Contact from '@/components/Contact'
import Privacy from '@/components/Privacy'
import NotFound from '@/components/NotFound'
import Login from '@/components/Login'

Vue.use(Router)

var router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {title: 'Home'}
    },
    {
      path: '/about',
      name: 'about',
      component: About,
      meta: {title: 'About'}
    },
    {
      path: '/login',
      name: 'login',
      component: Login,
      meta: {title: 'Login'}
    },
    {
      path: '/contact',
      name: 'contact',
      component: Contact,
      meta: {title: 'Contact Us'}
    },
    {
      path: '/privacy',
      name: 'privacy',
      component: Privacy,
      meta: {title: 'Privacy Policy'}
    },

    // 404 as Last Catch All Path
    {
      path: '*',
      component: NotFound,
      meta: {title: '404 Not Found'}
    }
  ]
});

router.afterEach(route => {
  document.title = route.meta.title + ' | TreasureHuntPWA';
});

export default router;
