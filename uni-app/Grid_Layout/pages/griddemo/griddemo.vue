<template>
	<view>
		<u-grid :col="3">
			<u-grid-item>
				<u-badge type="error" count="99" :offset="[20,20]"></u-badge>
				<view class="qq_color"><u-icon name="qq-circle-fill" :size="150"></u-icon></view>
				<view class="grid-text fixMessage">QQ</view>
			</u-grid-item>
			<u-grid-item>
				<u-badge type="error" count="12" :offset="[20,20]"></u-badge>
				<view class="weixin_color"><u-icon name="weixin-fill" :size="150"></u-icon></view>
				<view class="grid-text fixMessage">微信</view>
			</u-grid-item>
			<u-grid-item>
				<u-badge type="info" count="1" :offset="[20,20]"></u-badge>
				<view class="twitter_color"><u-icon name="twitter" :size="150"></u-icon></view>
				<view class="grid-text fixMessage">Twitter</view>
			</u-grid-item>
			<u-grid-item>
				<u-badge type="success" count="23" :offset="[20,20]"></u-badge>
				<view class="google_color"><u-icon name="google" :size="150"></u-icon></view>
				<view class="grid-text fixMessage">Google</view>
			</u-grid-item>
			<u-grid-item>
				<u-badge type="info" count="2" :offset="[20,20]"></u-badge>
				<view class="twitter_color"><u-icon name="baidu" :size="150"></u-icon></view>
				<view class="grid-text fixMessage">百度</view>
			</u-grid-item>
			<u-grid-item>
				<u-badge type="info" count="3" :offset="[20,20]"></u-badge>
				<view class="qq_color"><u-icon name="ie" :size="150"></u-icon></view>
				<view class="grid-text fixMessage">IE</view>
			</u-grid-item>
			<u-grid-item>
				<u-badge :is-dot="true" count="3" :offset="[20,20]"></u-badge>
				<view class="taobao_color"><u-icon name="taobao-circle-fill" :size="150"></u-icon></view>
				<view class="grid-text fixMessage">淘宝</view>
			</u-grid-item>
			<u-grid-item>
				<u-badge class="selfdefinebadge" count="4" :offset="[20,20]"></u-badge>
				<view class="twitter_color"><u-icon name="zhifubao-circle-fill" :size="150"></u-icon></view>
				<view class="grid-text fixMessage">支付宝</view>
			</u-grid-item>
			<u-grid-item>
				<!-- <image src="/static/index.png" class="badge-icon"></image> -->
				<u-badge type="error" count="13" :offset="[20,20]"></u-badge>
				<view class="twitter_color"><u-icon name="zhihu-circle-fill" :size="150"></u-icon></view>
				<view class="grid-text fixMessage">知乎</view>
			</u-grid-item>
		</u-grid :col="3">
	</view>
</template>

<script>
	export default{
		data(){
			return{
				
			}
		},
		methods:{
			
		}
	}
</script>

<style>
.qq_color{
	color:$u-type-primary-dark;
	color:#2b85e4;
}
.weixin_color{
	color:#19be6b;
}
.twitter_color{
	color:#2979ff;
}
.google_color{
	color:#FA3534;
}
.taobao_color{
	color:#FF5035;
}
.grid-text{
	font-size: 75rpx;
	/* margin-top: 4rpx; */
	margin-bottom: 1rpx;
}
.fixMessage{
	width: 90rpx;
	color: $u-main-color;
	color:#303133;
	font-size: 0.7em;
	/* font-size: 1em; */
	text-align: center;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}
.badge-icon{
	position: absolute;
	top: 14rpx;
	right: 65rpx;
	width: 40rpx;
	height: 40rpx;
}
.selfdefinebadge{
	background-color: #2b85e4;
	color: #FF5035;
}
</style>
