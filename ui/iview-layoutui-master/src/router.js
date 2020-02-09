import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'

Vue.use(Router)

export default new Router({
  // mode: 'history',
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import('@/components/Layout'),
      children:[
        {
          path: '',
          name: 'home',
          component: () => import('@/views/notice/notice')
        },
        {
          path: '/home',
          name: 'test',
          component: () => import('@/views/Home')
        },
        {
          path: '/notice/notice',
          name: 'test',
          component: () => import('@/views/notice/notice')
        }
      ]
    },
    {
      path:'/login',
      name:'login',
      meta:{
        title:'登录',
      },
      component: () => import('@/views/Login')
    },
  ]
})
