<template>
    <div ref="dom"></div>
</template>

<script>
import echarts from 'echarts'
import { on, off } from '@/libs/tools'
export default {
  name: 'serviceRequests',
  data () {
    return {
      dom: null
    }
  },
  methods: {
    resize () {
      this.dom.resize()
    }
  },
  mounted () {
    const option = {
      tooltip: {
        trigger: 'axis',
        axisPointer: {
          type: 'cross',
          label: {
            backgroundColor: '#6a7985'
          }
        }
      },
      grid: {
        top: '3%',
        left: '1.2%',
        right: '1%',
        bottom: '3%',
        containLabel: true
      },
      xAxis: [
        {
          type: 'category',
          boundaryGap: false,
          data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
        }
      ],
      yAxis: [
        {
          type: 'value'
        }
      ],
      series: [
        {
          name: '教师/点击量',
          type: 'line',
          stack: '总量',
          areaStyle: { normal: {
            color: '#2d8cf0'
          } },
          data: [10, 12, 11, 14, 9, 23, 21]
        },
        {
          name: '学生/点击量',
          type: 'line',
          stack: '总量',
          areaStyle: { normal: {
            color: '#10A6FF'
          } },
          data: [25, 35, 27, 24, 90, 30, 10]
        },
        {
          name: '管理员/点击量',
          type: 'line',
          stack: '总量',
          areaStyle: { normal: {
            color: '#0C17A6'
          } },
          data: [37, 26, 34, 29, 30, 48, 38]
      },
        {
          name: '报告/提交数',
          type: 'line',
          stack: '总量',
          label: {
            normal: {
              show: true,
              position: 'top'
            }
          },
          areaStyle: { normal: {
            color: '#398DBF'
          } },
          data: [20, 65, 6, 5, 2, 4, 2]
        }
      ]
    }
    this.$nextTick(() => {
      this.dom = echarts.init(this.$refs.dom)
      this.dom.setOption(option)
      on(window, 'resize', this.resize)
    })
  },
  beforeDestroy () {
    off(window, 'resize', this.resize)
  }
}
</script>
