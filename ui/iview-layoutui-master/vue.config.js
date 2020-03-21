module.exports = {
    baseUrl: 'iview-layoutui',
	 devServer: {
        // 设置主机地址
        host: 'localhost',
        // 设置默认端口
        port: 8081,
        // 设置代理
        proxy: {
                   '/graManagement': {
            target: 'http://localhost:8080/graManagement/task/delete',//设置你调用的接口域名和端口号 别忘了加http
            changeOrigin: true,
            pathRewrite: {
                '^/graManagement': '/graManagement'
            }
        }
    }


}
}