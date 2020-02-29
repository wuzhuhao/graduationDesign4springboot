import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'

Vue.use(Router)
const originalPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}


const router = new Router({
  // mode: 'history',
  routes: [
    //学生树
    {
      path: '/student',
      // name: 'student',
      component: () => import('@/components/Layout'),
      children:[
        {
          path: '',
          redirect: {
              name: 'studentHome'
          },
        },
        {
          path: '/notice',
          name: 'studentHome',
          component: () => import('@/views/Home')
        },
        {
          path: '/adminManage',
          name: 'adminManage',
          component: () => import('@/views/admin/adminManage')
        },
        {
          path: '/home',
          name: 'adminTest2',
          component: () => import('@/views/Home')
        },
        {
          path: '/admin/notice',
          name: 'adminNotice',
          component: () => import('@/views/Home')
        }
      ]
    },

    //管理员用户的树
    {
      path: '/admin',
      component: () => import('@/components/Layout'),
      children:[
        {
          path: '',
          redirect: {
              name: 'adminHome'
          },
        },
        {
          path: '/notice',
          name: 'adminHome',
          component: () => import('@/views/Home')
        },
        {
          path: '/studentManage',
          name: 'studentManage',
          component: () => import('@/views/admin/studentManage')
        },
        {
          path: '/teacherManage',
          name: 'teacherManage',
          component: () => import('@/views/admin/teacherManage')
        },
        {
          path: '/adminManage',
          name: 'adminManage',
          component: () => import('@/views/admin/adminManage')
        },
        {
          path: '/taskManage',
          name: 'taskManage',
          component: () => import('@/views/admin/taskManage2')
        },
        {
          path: '/admin/notice',
          name: 'adminNotice',
          component: () => import('@/views/Home')
        }
      ]
    },


    {
      path:'/',
      name:'login',
      meta:{
        title:'登录',
      },
      component: () => import('@/views/Login')
    },
    
  ]
})

// 导航守卫
// 使用 router.beforeEach 注册一个全局前置守卫，判断用户是否登陆
router.beforeEach((to, from, next) => {
  if (to.path === '/') {
    next();
  } else {
    let token = localStorage.getItem('token')
    if (token === 'null' || token === '') {
      next('/');
      
    } else {
      next();
    }
  }
});

export default router;
