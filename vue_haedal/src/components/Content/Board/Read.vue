<template>
    <div>
        <table class="tbAdd">
            <tr>
                <td class="re_content">번호</td>
                <td class="re_title">제목</td>
                <td class="re_writer">글쓴이</td>
            </tr>
            <tr :key="i" v-for="i in $store.state.userList.length" @click="detail($store.state.userList[i-1].b_id)">
                <td>{{ $store.state.userList[i-1].b_id }}</td>
                <td class="value_title">{{ $store.state.userList[i-1].b_title }}</td>
                <td>{{ $store.state.userList[i-1].b_name }}</td>
            </tr>
        </table>
        <div class="btnWrap">
        <p><a href="javascript:;" @click="write" class=" btnAdd btn">글쓰기</a></p>
        </div>
    </div>
</template>
<script>
export default {
    name: 'Read',
    computed: {
        doneGetUser() {
            this.$store.getters.getUser;
        }
    },
    methods: {
        getUser() {
            this.$store.dispatch('readUser');
            this.doneGetUser;
        },
        write(){
            this.$router.push({
                path: 'read/create'
            })
        },
        detail(id){
            this.$router.push({
                name: 'Detail',
                params: {
                    contentId: id
                }
            })
        },
        m_over(){
            text-decora
        },
        },
        mounted() {
            console.log("호출");
            this.getUser();
        }
}
</script>

<style scoped>
    .tbAdd td{border-bottom:1px solid #eee; padding:5px 0;}
    .tbAdd td{box-sizing:border-box; border-left:1px solid #eee;}
    .value_title:hover{text-decoration:underline; font-weight: bold;}
    .re_content{width: 10%;}
    .re_title{width: 70%;}
    .re_writer{width: 20%;}
    .btnWrap{text-align:center; margin:20px 0 0 0;}
	.btnWrap a{margin:0 10px; float:right; color:#eee;}
    .btnAdd {background:#43b984;}
    
</style>