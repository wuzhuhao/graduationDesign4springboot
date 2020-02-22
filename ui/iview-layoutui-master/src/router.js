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

    //管理员用户的树
    {
      path: '/admin',
      name: 'adminHome',
      component: () => import('@/views/admin/components/Layout'),
      children:[
        {
          path: '/admin/adminManage',
          name: 'adminManage',
          component: () => import('@/views/admin/adminManage')
        },
        {
          path: '/home',
          name: 'test1',
          component: () => import('@/views/Home')
        },
        {
          path: '/admin/notice',
          name: 'adminNotice',
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
