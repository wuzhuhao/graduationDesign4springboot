//  store.js 中都mutation中增加添加和删除token的方法
import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)

// const state = {     // 全局管理的数据存储
// 	 isLogin:'0',
// 	 ser:null,
// 	 token:localStorage.getItem('token') ? localStorage.getItem('token'):'',   // token
// };
export default new Vuex.Store({
	state:{
		user: {},
		userName: "",
		menus:[],
		type: '' || localStorage.getItem('type'),
		userId: '' || localStorage.getItem('userId'),
		// 存储token
		token: localStorage.getItem('token') ? localStorage.getItem('token') : '',
		theme1: localStorage.getItem('theme1') ? localStorage.getItem('theme1') : '',
		taskId: localStorage.getItem('taskId') ? localStorage.getItem('taskId') : '',
		theweeklyProgressIdme1: localStorage.getItem('weeklyProgressId') ? localStorage.getItem('weeklyProgressId') : '',
		acaId: localStorage.getItem('acaId') ? localStorage.getItem('acaId') : '',
	},

	getters:{    // 监听数据变化的
		getStorage(state){   // 获取本地存储的登录信息
	      if(!state.token){
	        state.token =JSON.parse(localStorage.getItem(key))
	      }
	      return state.token
		},
		type(state) {
			return state.type
			
		},
		userId(state) {
			return state.userId
			
		},
		theme1(state) {
			return state.theme1
			
		},
		token(state) {
			return state.token
			
		},	
		taskId(state) {
			return state.taskId
			
		},
		weeklyProgressId(state) {
			return state.weeklyProgressId
			
		},
		acaId(state) {
			return state.acaId
			
		},
	},
	setters:{    // 监听数据变化的
		
		
	},
	mutations:{
		token (state, token) {
			state.token = token;
			localStorage.setItem('token', token);
		  },
		type(state, type) {
			state.type = type
			  // 把登录的用户的名保存到localStorage中，防止页面刷新，导致vuex重新启动，用户名就成为初始值（初始值为空）的情况
			localStorage.setItem('type', type)
		  },
		  userId(state, userId) {
			state.userId = userId
			  // 把登录的用户的名保存到localStorage中，防止页面刷新，导致vuex重新启动，用户名就成为初始值（初始值为空）的情况
			localStorage.setItem('userId', userId)
		  },
		  theme1(state, theme1) {
			state.theme1 = theme1
			  // 把登录的用户的名保存到localStorage中，防止页面刷新，导致vuex重新启动，用户名就成为初始值（初始值为空）的情况
			localStorage.setItem('theme1', theme1)
		  },
		orderList(s, d) {
			s.menus= d;
			window.localStorage.setItem("menus",JSON.stringify(s.menus))
		  },
		
		token(state, token) { // 设置存储token
	        state.token = token;
	        localStorage.setItem('token', token);
		},
		taskId(state, taskId) { // 设置存储token
	        state.taskId = taskId;
	        localStorage.setItem('taskId', taskId);
		},
		weeklyProgressId(state, weeklyProgressId) { // 设置存储token
	        state.weeklyProgressId = weeklyProgressId;
	        localStorage.setItem('weeklyProgressId', weeklyProgressId);
		},
		acaId(state, acaId) { // 设置存储token
	        state.acaId = acaId;
	        localStorage.setItem('acaId', acaId);
	    },
	    removeStorage(state, value){  // 删除token
		      localStorage.removeItem('token');
		}
	}
})
