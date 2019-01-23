<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%--<!--<%@ taglib uri="/struts-tags" prefix="s" %>-->--%>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="../css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/animsition.min.css" />
    <link rel="stylesheet" href="../css/drop-down.css" />
    <link rel="stylesheet" href="../css/common.css" />
    <link rel="stylesheet" href="../css/qk.css" />
    <link rel="stylesheet" href="../css/xsfx.css">
</head>
<body>

<div id="jfhu" class="data_wrap" style="background: #efeff5; width: 1020px; padding: 10px; overflow: hidden;">
    <div class="animsition">

        <div class="xsfx_tips">
            1.学生实习情况分析<br />

            <i class="fa fa-close"></i>
        </div>

        <div class="qk_wrap" style=" margin-bottom: 10px; position: relative;">
            <div id="hdjf_tips">
            </div>
            <div>
                <div id="main1" class="my_main" style="width: 1020px;"></div>
            </div>

        </div>
        <div class="qk_wrap">
            <div>
                <div id="main2" class="my_main" style="width: 505px; height: 300px"></div>
            </div>
            <div>
                <div id="main3" class="my_main" style="width: 505px; height: 300px"></div>
            </div>

        </div>



    </div>
</div>

<script src="../js/jquery-latest.js"></script>
<script src="../js/jquery.tablesorter.min.js"></script>
<script src="../js/jquery.min.js"></script>
<script src="../js/jquery-ui.min.js"></script>
<script src="../js/select-widget-min.js"></script>
<script src="../js/jquery.animsition.min.js"></script>
<script src="../js/echarts.js"></script>
<script src="../js/macarons%20.js"></script>

<script>
    var $j=jQuery.noConflict();
    $j(document).ready(function() {
        //初始化切换
        $j(".animsition").animsition({

            inClass               :   'fade-in-right',
            outClass              :   'fade-out',
            inDuration            :    1500,
            outDuration           :    800,
            linkElement           :   '.animsition-link',
            // e.g. linkElement   :   'a:not([target="_blank"]):not([href^=#])'
            loading               :    true,
            loadingParentElement  :   'body', //animsition wrapper element
            loadingClass          :   'animsition-loading',
            unSupportCss          : [ 'animation-duration',
                '-webkit-animation-duration',
                '-o-animation-duration'
            ],
            //"unSupportCss" option allows you to disable the "animsition" in case the css property in the array is not supported by your browser.
            //The default setting is to disable the "animsition" in a browser that does not support "animation-duration".

            overlay               :   false,

            overlayClass          :   'animsition-overlay-slide',
            overlayParentElement  :   'body'
        });

        //虚拟数据
        var date = ['2018/11/1','2018/11/2','2018/11/3','2018/11/4','2018/11/5','2018/11/6','2018/11/7','2018/11/8','2018/11/9','2018/11/10',
            '2018/11/11','2018/11/12','2018/11/13','2018/11/14'];


        function my_data(){
            var data = [];
            for( var i =0; i<20; i++){
                data.push(Math.round(Math.random() * (50 - 10) + 10));
            }
            return data;
        }
        var num = my_data();
        var bl = '30%';

        //表格排序
        $("table").tablesorter();

        // 路径配置
        require.config({
            paths: {
                echarts: 'http://echarts.baidu.com/build/dist'
            }
        });

        // 使用
        require(
            [
                'echarts',
                'echarts/chart/bar',
                'echarts/chart/line',
                'echarts/chart/pie'// 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('main1'),'macarons');
                var myChart2 = ec.init(document.getElementById('main2'),'macarons');
                var myChart3 = ec.init(document.getElementById('main3'),'macarons');

                var option ={
                    title:{
                        text : '',
                        y: 15,
                        x : 20,
                        borderColor : '#ccc',
                        borderWidth : 1,
                        padding : [8, 15],
                        textStyle : {
                            fontSize : 14
                        }
                    },
                    backgroundColor:'white',
                    tooltip : {
                        trigger: 'axis',
                        formatter : function(data){
                            //console.log(data[0].name)
                            option2.title.subtext = data[0].name;
                            option2.series[0].data = [
                                {value:900, name:'大城市'},
                                {value:150, name:'小城市'}
                            ];
                            option2.series[1].data = [
                                {value:10, name:'出国'},
                                {value:20, name:'北京'},
                                {value:110, name:'长三角'},
                                {value:500, name:'珠三角'},
                                {value:30, name:'长沙'},
                                {value:50, name:'创业'}
                            ];
                            option3.title.subtext = data[0].name;
                            option3.series[0].data = [
                                {value:900, name:'大城市'},
                                {value:150, name:'小城市'}
                            ];
                            option3.series[1].data = [
                                {value:10, name:'出国'},
                                {value:20, name:'北京'},
                                {value:110, name:'长三角'},
                                {value:500, name:'珠三角'},
                                {value:30, name:'长沙'},
                                {value:50, name:'创业'}
                            ];
                            myChart2.clear();
                            myChart2.setOption(option3,true);
                            myChart3.clear();
                            myChart3.setOption(option3,true);
                            var str = data[1].name ;
                            str += '</br>' + data[0].seriesName + ':' + data[0].value;
                            str += '</br>实习学生：100';
                            str += '</br>就业学生：200';
                            str += '</br>' + data[1].seriesName + ':' + data[1].value;
                            $j('#hdjf_date').html(data[1].name);
                            $j('#hdjf_hdl').html('互动率：10%');
                            $j('#hdjf_hgl').html('回购率：20%');
                            $j('#hdjf_je').html('金额：456');
                            return str;

                        }
                    },
                    legend: {
                        selectedMode : false,
                        data:['实习人数','就业人数'],
                        y:'20'
                    },
                    grid:{
                        y:'100'
                    },
                    toolbox: {
                        show : false,
                        y:'20',
                        feature : {
                            mark : {show: false},
                            dataView : {show: true, readOnly: false},
                            magicType : {show: true, type: ['line', 'bar']},
                            restore : {show: true},
                            saveAsImage : {show: true}
                        }
                    },
                    dataZoom : {
                        show : true,
                        realtime : true,
                        y: 320,
                        height: 20,
                        start : 70,
                        end : 100
                    },
                    calculable : true,
                    xAxis : [
                        {
                            type : 'category',
                            boundaryGap : true,
                            data : date
                        }
                    ],
                    yAxis : [
                        {
                            name : '',
                            type : 'value'
                        }
                    ],
                    series : [
                        {
                            name:'赚积分',
                            type:'bar',
                            //stack: '总量',
                            barMaxWidth : 15,
                            itemStyle:{
                                normal:{
                                    borderWidth : 3
                                }
                            },
                            data:my_data()
                        },
                        {

                            type:'bar',
                            //stack: '总量',
                            barMaxWidth : 15,
                            itemStyle:{
                                normal:{
                                    borderWidth : 3
                                }
                            },
                            data:my_data()
                        }
                    ]
                };
                var option2 = {
                    title :{
                        text : '实习地区占比',
                        subtext : '2017-1-1',
                        textStyle : {
                            fontSize : 14
                        }
                    },
                    backgroundColor : 'white',
                    tooltip : {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        show : false,
                        orient : 'vertical',
                        x : 'left',
                        data:['一线城市','非一线城市','进店送积分','签到送积分','收藏送积分','推荐送积分','南方','生日送积分','微博送积分']
                    },
                    toolbox: {
                        show : false,
                        feature : {
                            mark : {show: false},
                            dataView : {show: true, readOnly: false},

                            restore : {show: true},
                            saveAsImage : {show: true}
                        }
                    },
                    calculable : false,
                    series : [
                        {
                            name:'赚积分来源',
                            type:'pie',
                            selectedMode: 'single',
                            radius : [0, 50],
                            itemStyle : {
                                normal : {
                                    label : {
                                        position : 'inner'
                                    },
                                    labelLine : {
                                        show : false
                                    }
                                }
                            },
                            data:[
                                {value:335, name:'大城市'},
                                {value:679, name:'小城市'}
                            ]
                        },
                        {
                            name:'赚积分占比',
                            type:'pie',
                            radius : [65, 85],

                            // for funnel
                            x: '60%',
                            width: '35%',
                            funnelAlign: 'left',

                            data:[
                                {value:335, name:'上海'},
                                {value:1048, name:'北京'},
                                {value:234, name:'长沙'},
                                {value:135, name:'天津'},
                                {value:310, name:'广州'},
                                {value:251, name:'出国'},
                                {value:147, name:'沈阳'}
                            ]
                        }
                    ]
                };

                var option3 = {
                    title :{

                        subtext : '2017-1-1',
                        textStyle : {
                            fontSize : 14
                        }
                    },
                    backgroundColor : 'white',
                    tooltip : {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        show : false,
                        orient : 'vertical',
                        x : 'left',
                        data:['小城市','大城市','沈阳','大连','南方','北方','出国','珠三角']
                    },
                    toolbox: {
                        show : false,
                        feature : {
                            mark : {show: false},
                            dataView : {show: true, readOnly: false},

                            restore : {show: true},
                            saveAsImage : {show: true}
                        }
                    },
                    calculable : false,
                    series : [
                        {

                            type:'pie',
                            selectedMode: 'single',
                            radius : [0, 50],
                            itemStyle : {
                                normal : {
                                    label : {
                                        position : 'inner'
                                    },
                                    labelLine : {
                                        show : false
                                    }
                                }
                            },
                            data:[
                                {value:335, name:'PC端'},
                                {value:679, name:'手机端'}
                            ]
                        },
                        {

                            type:'pie',
                            radius : [65, 85],

                            // for funnel
                            x: '60%',
                            width: '35%',
                            funnelAlign: 'left',

                            data:[
                                {value:335, name:'南方'},
                                {value:310, name:'北方'},
                                {value:234, name:'长三角'},
                                {value:1048, name:'珠三角'},
                                {value:135, name:'出国'},
                                {value:251, name:'创业'}
                            ]
                        }
                    ]
                };
                var ecConfig = require('echarts/config');

                // 为echarts对象加载数据
                myChart.setOption(option);
                myChart2.setOption(option2);
                myChart3.setOption(option3);
            }
        );
        //关闭提示
        $j('.xsfx_tips  i').on('click',function(){
            $j(this).parent().slideUp();
        });

        $j('.tablesorter tbody tr').hover(function () {
            $(this).css('background','#d9edf7');
        },function () {
            $(this).css('background','none');
        })

    });
</script>
</body>
</html>
