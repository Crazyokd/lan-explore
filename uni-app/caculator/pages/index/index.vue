<template>
	<view class="content">
		<!-- <image class="logo" src="/static/logo.png"></image> -->
<!-- 		<view class="text-area">
			<text class="title">{{title}}</text>
		</view> -->
		<view class="top">
			<text class="display">{{result}}</text>
		</view>
		<view>
			<image class="buttonone" src=../../static/arrow.png @click="deleteone()"></image>
			<image class="buttonone" src=../../static/sqrt.png></image>
			<image class="buttonone" src=../../static/+-.png></image>
			<image class="buttonpower" src=../../static/back.jpg></image>
		</view>
		<view>
			<image class="buttonoff" src=../../static/secondline.png.jpg></image>
		</view>	
		<view>
			<image class="button" src=../../static/ac.png @click="clear()"></image>
			<image class="button" src=../../static/7.png @click="addstring('7')"></image>
			<image class="button" src=../../static/8.png @click="addstring('8')"></image>
			<image class="button" src=../../static/9.png @click="addstring('9')"></image>
			<image class="button" src=../../static/percent.png></image>
			<image class="button" src=../../static/mu.png></image>
		</view>
		<view>
			<image class="button" src=../../static/c.png @click="deleteone()"></image>
			<image class="button" src=../../static/4.png @click="addstring('4')"></image>
			<image class="button" src=../../static/5.png @click="addstring('5')"></image>
			<image class="button" src=../../static/6.png @click="addstring('6')"></image>
			<image class="button" src=../../static/mul.png @click="addstring('*')"></image>
			<image class="button" src=../../static/div.png @click="addstring('/')"></image>
		</view>
		<view class="lasttwoouter">
			<view class="lasttwo">
				<image class="button" src=../../static/ce.png></image>
				<image class="button" src=../../static/on.png></image>
			</view>
			<view class="lasttwo">
				<image class="button" src=../../static/1.png @click="addstring('1')"></image>
				<image class="button" src=../../static/0.png @click="addstring('0')"></image>
			</view>
			<view class="lasttwo">
				<image class="button" src=../../static/2.png @click="addstring('2')"></image>
				<image class="button" src=../../static/00.png @click="addstring('00')"></image>
			</view>
			<view class="lasttwo">
				<image class="button" src=../../static/3.png @click="addstring('3')"></image>
				<image class="button" src=../../static/point.png @click="addstring('.')"></image>
			</view>
			<view class="lasttwo">
				<image class="buttonadd" src=../../static/+.png @click="addstring('+')"></image>
			</view>
			<view class="lasttwo">
				<image class="button" src=../../static/-.png @click="addstring('-')"></image>
				<image class="button" src=../../static/equal.png @click="equal()"></image>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				// title: 'Hello',
				result:""
			}
		},
		onLoad() {
			
		},
		methods: {
			deleteone(){
				this.result=this.result.substring(0,this.result.length-1);
			},
			clear(){
				this.result="";
			},
			addstring(operator){
				this.result+=operator;
			},
			equal(){
				try{
					this.result=eval(this.result);
				}catch(e){
					this.result="err";
				}
			}
		}
	}
</script>

<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		/* justify-content: center; */
		justify-content: flex-start;
	}
	
	.top{
		display: flex;
		align-items: center;
		justify-content: flex-end;
		width: 720rpx;
		height: 200rpx;
		background-image: url(../../static/screen.png);
		background-size: 100% 100%;
		background-repeat: no-repeat;
	}
	.display{
		margin-right: 120rpx;
	}
	.buttonone{
		width: 150rpx;
		height: 110rpx;
	}
	.buttonpower{
		width: 250rpx;
		height: 120rpx;
	}
	.buttonoff{
		width: 700rpx;
		height: 120rpx;
	}
	.button{
		width: 110rpx;
		height: 110rpx;
		margin-right: 5rpx;
	}
	.lasttwoouter{
		display: flex;
		flex-direction: row;
	}
	.lasttwo{
		display: flex;
		flex-direction: column;
	}
	.buttonadd{
		width: 110rpx;
		height: 220rpx;
	}
/* 	.logo {
		height: 200rpx;
		width: 200rpx;
		margin-top: 200rpx;
		margin-left: auto;
		margin-right: auto;
		margin-bottom: 50rpx;
	}

	.text-area {
		display: flex;
		justify-content: center;
	}

	.title {
		font-size: 36rpx;
		color: #8f8f94;
	} */
</style>
