<template>
    <div>
        <h2 class="de_title">{{$store.state.userList.b_title}}</h2>
        <div class="de_writer">{{$store.state.userList.b_name}}</div>
        <div class="de_content">{{$store.state.userList.b_content}}</div>
        <div class="btnWrap">
            <a href="javascript:;" @click="updateData" class="btnAdd btn">수정</a>
            <a href="javascript:;" @click="deleteUser($store.state.userList.b_id)" class="btn">삭제</a>
        </div>
    </div>
</template>

<script>
export default {
    name: 'Detail',
    methods: {
        getUserOne(id) {
            this.$store.dispatch('readUserOne', id)
        },
        deleteUser(id) {
            this.$store.dispatch('deleteUser', id)
            this.$router.push({
                path: '/read'
            })
        },
        updateData(){
            this.$router.push({
                name: 'Create',
                params: {
                    contentId: this.$store.state.userList.b_id
                }
                // path:'/read/create/contentId?'
            })
        }
    },

    created() {
        const id = this.$route.params.contentId;
        if(id == undefined) {
            alert("오류입니다.");
            this.$router.push('/read');
        }
    },
    mounted() {
        const id = this.$route.params.contentId;
        this.getUserOne(id);
    }
}
</script>
<style>
    .de_title{text-align: left; height: 20px;}
    .de_writer{text-align: left; margin: 10px;}
    .btnWrap{text-align:center; margin:20px 0 0 0;}
    .btnWrap a{margin:0 10px; display:inline-block;}
    .btn{padding:10px; background:#34445c; color:#fff;}
    .btnAdd {background:#43b984}
    .btnDelete{background:#f00;}
</style>