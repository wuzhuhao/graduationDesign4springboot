import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'

Vue.use(Router)
const originalPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

const router = new Router({
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
              name: 'studentNotice'
          },
        },
        {
          path: '/studentNotice',
          name: 'studentNotice',
          component: () => import('@/views/notice/notice')
        },
        {
          path: '/noticeInfo',
          name: 'noticeInfo',
          component: () => import('@/views/notice/noticeInfo')
        },
       
        {
          path: '/showNotice',
          name: 'showNotice',
          component: () => import('@/views/notice/showNotice')
        },
        {
          path: '/studentSubject',
          name: 'studentSubject',
          component: () => import('@/views/student/studentSubject')
        },
        {
          path: '/studentSelection',
          name: 'studentSelection',
          component: () => import('@/views/student/studentSelection')
        },{
          path: '/noAcceptedAssignment',
          name: 'noAcceptedAssignment',
          component: () => import('@/views/student/noAcceptedAssignment')
        },{
          path: '/acceptedAssignment',
          name: 'acceptedAssignment',
          component: () => import('@/views/student/acceptedAssignment')
        },{
          path: '/checkReport',
          name: 'checkReport',
          component: () => import('@/views/student/checkReport')
        },{
          path: '/weeklyProgress',
          name: 'weeklyProgress',
          component: () => import('@/views/student/weeklyProgress')
        },{
          path: '/designshow',
          name: 'designshow',
          component: () => import('@/views/student/designshow')
        },{
          path: '/finalThesis',
          name: 'finalThesis',
          component: () => import('@/views/student/finalThesis')
        },{
          path: '/replyTeam',
          name: 'replyTeam',
          component: () => import('@/views/student/replyTeam')
        },
        {
          path: '/home',
          name: 'adminTest2',
          component: () => import('@/views/notice/notice')
        },
        {
          path: '/studentScore',
          name: 'studentScore',
          component: () => import('@/views/student/studentScore')
        },
        {
          path: '/studentInfo',
          name: 'studentInfo',
          component: () => import('@/views/student/studentInfo')
        }
      ]
    },


//教师的树
  {
    path: '/teacher',
    // name: 'student',
    component: () => import('@/components/Layout'),
    children:[
      {
        path: '',
        redirect: {
            name: 'studentNotice'
        },
      },
      {
        path: '/notice',
        name: 'studentHome',
        component: () => import('@/views/notice/notice')
      },
      {
    
        
        path: '/fileDownload',
        name: 'fileDownload',
        component: () => import('@/views/teacher/fileDownload')
      },
      {
        path: '/scheduleQuery',
        name: 'scheduleQuery',
        component: () => import('@/views/teacher/scheduleQuery')
      },
      {
        path: '/teacherReport',
        name: 'teacherReport',
        component: () => import('@/views/teacher/teacherReport')
      },
      {
        path: '/submitAssignment',
        name: 'submitAssignment',
        component: () => import('@/views/teacher/submitAssignment')
      },
      {
        path: '/subjectMessage',
        name: 'subjectMessage',
        component: () => import('@/views/teacher/subjectMessage')
      },
      {
        path: '/noDesignatedTopic',
        name: 'noDesignatedTopic',
        component: () => import('@/views/teacher/noDesignatedTopic')
      },
      {
        path: '/designatedTopic',
        name: 'designatedTopic',
        component: () => import('@/views/teacher/designatedTopic')
      },
      {
        path: '/teacherNoAcceptedAssignment',
        name: 'teacherNoAcceptedAssignment',
        component: () => import('@/views/teacher/teacherNoAcceptedAssignment')
      },
      {
        path: '/taacherAcceptedAssignment',
        name: 'taacherAcceptedAssignment',
        component: () => import('@/views/teacher/taacherAcceptedAssignment')
      },
      {
        path: '/teacherCheckReport',
        name: 'teacherCheckReport',
        component: () => import('@/views/teacher/teacherCheckReport')
      },
      {
        path: '/teacherWeeklyProgress',
        name: 'teacherWeeklyProgress',
        component: () => import('@/views/teacher/teacherWeeklyProgress')
      },
      {
        path: '/teacherScore',
        name: 'teacherScore',
        component: () => import('@/views/teacher/teacherScore')
      },
      {
        path: '/entryScore',
        name: 'entryScore',
        component: () => import('@/views/teacher/entryScore')
      },
      {
        path: '/teacherFinalThesis',
        name: 'teacherFinalThesis',
        component: () => import('@/views/teacher/teacherFinalThesis')
      },
      //{
      //   path: '/replyTeam',
      //   name: 'replyTeam',
      //   component: () => import('@/views/student/replyTeam')
      // },
      // {
      //   path: '/home',
      //   name: 'adminTest2',
      //   component: () => import('@/views/Home')
      // },
      // {
      //   path: '/admin/notice',
      //   name: 'adminNotice',
      //   component: () => import('@/views/Home')
      // },
      {
        path: '/teacherInfo',
        name: 'teacherInfo',
        component: () => import('@/views/teacher/teacherInfo')
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
          path: '/adminHome',
          name: 'adminHome',
          component: () => import('@/views/admin/home/home')
        },
        
        {
          path: '/dictManage',
          name: 'dictManage',
          component: () => import('@/views/admin/dictManage')
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
          component: () => import('@/views/admin/taskManage')
        },
        {
          path: '/subjectManage',
          name: 'subjectManage',
          component: () => import('@/views/admin/subjectManage')
        },
        {
          path: '/logOperationManage',
          name: 'logOperationManage',
          component: () => import('@/views/admin/logOperationManage')
        },
        {
          path: '/replyTeamManage',
          name: 'replyTeamManage',
          component: () => import('@/views/admin/replyTeamManage')
        },
        {
          path: '/academyManage',
          name: 'academyManage',
          component: () => import('@/views/admin/academyManage')
        },
        {
          path: '/applyManage',
          name: 'applyManage',
          component: () => import('@/views/admin/applyManage')
        },
        {
          path: '/designShowManage',
          name: 'designShowManage',
          component: () => import('@/views/admin/designShowManage')
        },
        {
          path: '/goodGraduationManage',
          name: 'goodGraduationManage',
          component: () => import('@/views/admin/goodGraduationManage')
        },
        {
          path: '/noticeManage',
          name: 'noticeManage',
          component: () => import('@/views/admin/noticeManage')
        },
        {
          path: '/progressManage',
          name: 'progressManage',
          component: () => import('@/views/admin/progressManage')
        },
        {
          path: '/reportManage',
          name: 'reportManage',
          component: () => import('@/views/admin/reportManage')
        },
        
        {
          path: '/EntryOfDefenseScore',
          name: 'EntryOfDefenseScore',
          component: () => import('@/views/admin/EntryOfDefenseScore')
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
  if (to.path === '/' ) {
    next();
  } else {
    let token = localStorage.getItem('token');
    if (token === null || token === '') {
      this.$Message.warning('请登录');
      next('/');
    } else {
      next();
    }
  }
});

export default router;
