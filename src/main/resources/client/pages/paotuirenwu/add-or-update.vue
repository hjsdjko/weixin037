<template>
<view class="content">
	<view :style='{"width":"100%","padding":"0 0 0 0","position":"relative","background":"#ffffff","height":"100%"}'>
		<form :style='{"width":"100%","padding":"24rpx 24rpx 24rpx 24rpx","background":"#ffffff","display":"block","height":"auto"}' class="app-update-pv">
			<view :style='{"padding":"4rpx 0 4rpx 0","margin":"0 0 24rpx 0","borderColor":"#cccccc","alignItems":"center","borderRadius":"8rpx 0 0 8rpx","borderWidth":"0px","background":"#e7fefc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}' class="title">任务名称</view>
				<input :style='{"border":"0px solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"8rpx","flex":"1","background":"#ffffff00","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' :disabled="ro.renwumingcheng" v-model="ruleForm.renwumingcheng" placeholder="任务名称"></input>
			</view>
			<view :style='{"padding":"4rpx 0 4rpx 0","margin":"0 0 24rpx 0","borderColor":"#cccccc","alignItems":"center","borderRadius":"8rpx 0 0 8rpx","borderWidth":"0px","background":"#e7fefc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="" @tap="fengmianTap">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}' class="title">封面</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-if="ruleForm.fengmian" :src="baseUrl+ruleForm.fengmian.split(',')[0]" mode="aspectFill"></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
			</view>
			<view :style='{"padding":"4rpx 0 4rpx 0","margin":"0 0 24rpx 0","borderColor":"#cccccc","alignItems":"center","borderRadius":"8rpx 0 0 8rpx","borderWidth":"0px","background":"#e7fefc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}' class="title">取件地方</view>
				<input :style='{"border":"0px solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"8rpx","flex":"1","background":"#ffffff00","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' :disabled="ro.qujiandifang" v-model="ruleForm.qujiandifang" placeholder="取件地方"></input>
			</view>
			<view :style='{"padding":"4rpx 0 4rpx 0","margin":"0 0 24rpx 0","borderColor":"#cccccc","alignItems":"center","borderRadius":"8rpx 0 0 8rpx","borderWidth":"0px","background":"#e7fefc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}' class="title">送达地方</view>
				<input :style='{"border":"0px solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"8rpx","flex":"1","background":"#ffffff00","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' :disabled="ro.songdadifang" v-model="ruleForm.songdadifang" placeholder="送达地方"></input>
			</view>
			<view :style='{"padding":"4rpx 0 4rpx 0","margin":"0 0 24rpx 0","borderColor":"#cccccc","alignItems":"center","borderRadius":"8rpx 0 0 8rpx","borderWidth":"0px","background":"#e7fefc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}' class="title">需求时间</view>
				<input :style='{"border":"0px solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"8rpx","flex":"1","background":"#ffffff00","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' v-model="ruleForm.xuqiushijian" placeholder="需求时间" @tap="toggleTab('xuqiushijian')"></input>
			</view>
			<view :style='{"padding":"4rpx 0 4rpx 0","margin":"0 0 24rpx 0","borderColor":"#cccccc","alignItems":"center","borderRadius":"8rpx 0 0 8rpx","borderWidth":"0px","background":"#e7fefc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}' class="title">报酬</view>
				<input :style='{"border":"0px solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"8rpx","flex":"1","background":"#ffffff00","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' :disabled="ro.baochou" v-model="ruleForm.baochou" placeholder="报酬"></input>
			</view>
			<view :style='{"padding":"4rpx 0 4rpx 0","margin":"0 0 24rpx 0","borderColor":"#cccccc","alignItems":"center","borderRadius":"8rpx 0 0 8rpx","borderWidth":"0px","background":"#e7fefc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}' class="title">任务状态</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}' @change="renwuzhuangtaiChange" :value="renwuzhuangtaiIndex"  :range="renwuzhuangtaiOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#666666"}' class="uni-input">{{ruleForm.renwuzhuangtai?ruleForm.renwuzhuangtai:"请选择任务状态"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"4rpx 0 4rpx 0","margin":"0 0 24rpx 0","borderColor":"#cccccc","alignItems":"center","borderRadius":"8rpx 0 0 8rpx","borderWidth":"0px","background":"#e7fefc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}' class="title">发布时间</view>
				<input :style='{"border":"0px solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"8rpx","flex":"1","background":"#ffffff00","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' v-model="ruleForm.fabushijian" placeholder="发布时间" @tap="toggleTab('fabushijian')"></input>
			</view>
			<view :style='{"padding":"4rpx 0 4rpx 0","margin":"0 0 24rpx 0","borderColor":"#cccccc","alignItems":"center","borderRadius":"8rpx 0 0 8rpx","borderWidth":"0px","background":"#e7fefc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}' class="title">账号</view>
				<input :style='{"border":"0px solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"8rpx","flex":"1","background":"#ffffff00","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' :disabled="ro.zhanghao" v-model="ruleForm.zhanghao" placeholder="账号"></input>
			</view>
			<view :style='{"padding":"4rpx 0 4rpx 0","margin":"0 0 24rpx 0","borderColor":"#cccccc","alignItems":"center","borderRadius":"8rpx 0 0 8rpx","borderWidth":"0px","background":"#e7fefc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}' class="title">姓名</view>
				<input :style='{"border":"0px solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"8rpx","flex":"1","background":"#ffffff00","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' :disabled="ro.xingming" v-model="ruleForm.xingming" placeholder="姓名"></input>
			</view>
			<view :style='{"padding":"4rpx 0 4rpx 0","margin":"0 0 24rpx 0","borderColor":"#cccccc","alignItems":"center","borderRadius":"8rpx 0 0 8rpx","borderWidth":"0px","background":"#e7fefc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}' class="title">手机</view>
				<input :style='{"border":"0px solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"8rpx","flex":"1","background":"#ffffff00","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' :disabled="ro.shouji" v-model="ruleForm.shouji" placeholder="手机"></input>
			</view>
			
			<!-- 否 -->
 

			
			
			<view :style='{"width":"100%","justifyContent":"center","display":"flex","height":"auto"}' class="btn" >
				<button :style='{"border":"0px solid #eeeeee","padding":"0 0 0 0","boxShadow":"0px 12rpx 12rpx -12rpx #228a7f","margin":"0 4% 0 0","color":"#ffffff","borderRadius":"40rpx 0 0 0","background":"#75ebde","width":"30%","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' @tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

		<w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="xuqiushijianConfirm" ref="xuqiushijian" themeColor="#333333"></w-picker>
		<w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="fabushijianConfirm" ref="fabushijian" themeColor="#333333"></w-picker>
	</view>
</view>
</template>

<script>
	import wPicker from "@/components/w-picker/w-picker.vue";
    import xiaEditor from '@/components/xia-editor/xia-editor';
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
				cross:'',
				ruleForm: {
				renwumingcheng: '',
				fengmian: '',
				qujiandifang: '',
				songdadifang: '',
				xuqiushijian: '',
				baochou: '',
			        renwuzhuangtai: '待接单',
				fabushijian: '',
				zhanghao: '',
				xingming: '',
				shouji: '',
				},
				renwuzhuangtaiOptions: [],
				renwuzhuangtaiIndex: 0,
				// 登录用户信息
				user: {},
                ro:{
                   renwumingcheng : false,
                   fengmian : false,
                   qujiandifang : false,
                   songdadifang : false,
                   xuqiushijian : false,
                   baochou : false,
                   renwuzhuangtai : false,
                   fabushijian : false,
                   zhanghao : false,
                   xingming : false,
                   shouji : false,
                },
			}
		},
		components: {
			wPicker,
            xiaEditor,
            multipleSelect
		},
		watch:{
		},
		async onLoad(options) {
            this.ruleForm.fabushijian = this.$utils.getCurDateTime();

			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取
			this.ruleForm.zhanghao = this.user.zhanghao
			this.ro.zhanghao = true;
			this.ruleForm.xingming = this.user.xingming
			this.ro.xingming = true;
			this.ruleForm.shouji = this.user.shouji
			this.ro.shouji = true;


			// 自定义下拉框值
			this.renwuzhuangtaiOptions = "已接单,待接单".split(',')

			// 如果有登录，获取登录后保存的userid
			this.ruleForm.userid = uni.getStorageSync("userid")
			if (options.refid) {
				// 如果上一级页面传递了refid，获取改refid数据信息
				this.ruleForm.refid = options.refid;
				this.ruleForm.nickname = uni.getStorageSync("nickname");
			}
			// 如果是更新操作
			if (options.id) {
				this.ruleForm.id = options.id;
				// 获取信息
				res = await this.$api.info(`paotuirenwu`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
					if(o=='renwumingcheng'){
					this.ruleForm.renwumingcheng = obj[o];
					this.ro.renwumingcheng = true;
					continue;
					}
					if(o=='fengmian'){
					this.ruleForm.fengmian = obj[o].split(",")[0];
					this.ro.fengmian = true;
					continue;
					}
					if(o=='qujiandifang'){
					this.ruleForm.qujiandifang = obj[o];
					this.ro.qujiandifang = true;
					continue;
					}
					if(o=='songdadifang'){
					this.ruleForm.songdadifang = obj[o];
					this.ro.songdadifang = true;
					continue;
					}
					if(o=='xuqiushijian'){
					this.ruleForm.xuqiushijian = obj[o];
					this.ro.xuqiushijian = true;
					continue;
					}
					if(o=='baochou'){
					this.ruleForm.baochou = obj[o];
					this.ro.baochou = true;
					continue;
					}
					if(o=='renwuzhuangtai'){
					this.ruleForm.renwuzhuangtai = obj[o];
					this.ro.renwuzhuangtai = true;
					continue;
					}
					if(o=='fabushijian'){
					this.ruleForm.fabushijian = obj[o];
					this.ro.fabushijian = true;
					continue;
					}
					if(o=='zhanghao'){
					this.ruleForm.zhanghao = obj[o];
					this.ro.zhanghao = true;
					continue;
					}
					if(o=='xingming'){
					this.ruleForm.xingming = obj[o];
					this.ro.xingming = true;
					continue;
					}
					if(o=='shouji'){
					this.ruleForm.shouji = obj[o];
					this.ro.shouji = true;
					continue;
					}
				}
			}
			this.styleChange()
            this.$forceUpdate()
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		methods: {
			styleChange() {
				this.$nextTick(()=>{
					document.querySelectorAll('.radioText').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"color":"#666666"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.radioTextActive').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"color":"#00babd"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.checkText').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"color":"#666666"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.checkTextActive').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"color":"#00babd"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.uni-radio-input').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"border":"2rpx solid #999999","borderRadius":"100%","background":"#ffffff"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.uni-radio-input-checked').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"border":"2rpx solid #00babd","borderRadius":"100%","background":"#19d2d5"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.uni-checkbox-input').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"border":"2rpx solid #999999","borderRadius":"100%","background":"#ffffff"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.uni-checkbox-input-checked').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"border":"2rpx solid #00babd","color":"#ffffff","borderRadius":"100%","background":"#19d2d5"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
				})
			},

			// 多级联动参数

			// 日长控件选择日期时间
			xuqiushijianConfirm(val) {
				console.log(val)
				this.ruleForm.xuqiushijian = val.result;
				this.$forceUpdate();
			},
			// 日长控件选择日期时间
			fabushijianConfirm(val) {
				console.log(val)
				this.ruleForm.fabushijian = val.result;
				this.$forceUpdate();
			},

			// 下拉变化
			renwuzhuangtaiChange(e) {
				this.renwuzhuangtaiIndex = e.target.value
				this.ruleForm.renwuzhuangtai = this.renwuzhuangtaiOptions[this.renwuzhuangtaiIndex]
			},

			fengmianTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.fengmian = 'file/' + res.file;
					_this.$forceUpdate();
					_this.$nextTick(()=>{
						_this.styleChange()
					})
				});
			},

			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {























//跨表计算判断
				var obj;
				if(this.ruleForm.baochou&&(!this.$validate.isNumber(this.ruleForm.baochou))){
					this.$utils.msg(`报酬应输入数字`);
					return
				}
				if(this.ruleForm.shouji&&(!this.$validate.isMobile(this.ruleForm.shouji))){
					this.$utils.msg(`手机应输入手机格式`);
					return
				}
				//更新跨表属性
			       var crossuserid;
			       var crossrefid;
			       var crossoptnum;
				if(this.cross){
                    uni.setStorageSync('crossCleanType',true);
					var statusColumnName = uni.getStorageSync('statusColumnName');
					var statusColumnValue = uni.getStorageSync('statusColumnValue');
					if(statusColumnName!='') {
                        if(!obj) {
						    obj = uni.getStorageSync('crossObj');
                        }
						if(!statusColumnName.startsWith("[")) {
							for (var o in obj){
								if(o==statusColumnName){
									obj[o] = statusColumnValue;
								}

							}
							var table = uni.getStorageSync('crossTable');
							await this.$api.update(`${table}`, obj);
						} else {
						       crossuserid=Number(uni.getStorageSync('userid'));
						       crossrefid=obj['id'];
						       crossoptnum=uni.getStorageSync('statusColumnName');
						       crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
						}
					}
				}
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid=crossuserid;
					this.ruleForm.crossrefid=crossrefid;
					let params = {
						page: 1,
						limit:10,
						crossuserid:crossuserid,
						crossrefid:crossrefid,
					}
					let res = await this.$api.list(`paotuirenwu`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
                        uni.removeStorageSync('crossCleanType');
						return false;
					} else {
                //跨表计算
						if(this.ruleForm.id){
							await this.$api.update(`paotuirenwu`, this.ruleForm);
						}else{
							await this.$api.add(`paotuirenwu`, this.ruleForm);
						}
						this.$utils.msgBack('提交成功');
					}
				} else {
                //跨表计算
					if(this.ruleForm.id){
						await this.$api.update(`paotuirenwu`, this.ruleForm);
					}else{
						await this.$api.add(`paotuirenwu`, this.ruleForm);
					}
					this.$utils.msgBack('提交成功');
				}
			},
			optionsChange(e) {
				this.index = e.target.value
			},
			bindDateChange(e) {
				this.date = e.target.value
			},
			getDate(type) {
				const date = new Date();
				let year = date.getFullYear();
				let month = date.getMonth() + 1;
				let day = date.getDate();
				if (type === 'start') {
					year = year - 60;
				} else if (type === 'end') {
					year = year + 2;
				}
				month = month > 9 ? month : '0' + month;;
				day = day > 9 ? day : '0' + day;
				return `${year}-${month}-${day}`;
			},
			toggleTab(str) {
				this.$refs[str].show();
			},
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
