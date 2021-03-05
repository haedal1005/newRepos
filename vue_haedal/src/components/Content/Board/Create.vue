<template>
<div>
  <h1>게시판 등록</h1>
  <div class="AddWrap">
    <form>
      <table class="tbAdd">
        <colgroup>
          <col width="15%" />
          <col width="*" />
        </colgroup>
        <tr>
          <th>작성자</th>
          <td><input type="text" v-model="name" placeholder="작성자를 입력하세요" /></td>
        </tr>
        <tr>
          <th>제목</th>
          <td><input type="text" v-model="title" placeholder="제목을 입력하세요" /></td>
        </tr>
        <tr>
          <th>내용</th>
          <td><textarea v-model="content" placeholder="내용을 입력하세요"></textarea></td>
        </tr>
        <tr>
          <th>비밀번호</th>
          <td><input type="text" v-model="pw" placeholder="비밀번호를 입력하세요"/></td>
        </tr>
      </table>
    </form>
  </div>
  <div class="btnWrap">
    <a href="javascript:;" @click="fnList" class="btn">목록</a>
    <a href="javascript:;" @click="id !== undefined ? update() : addUser()" class="btnAdd btn">{{id !== undefined ? '수정' : '작성'}}</a>
  </div>
</div>
<!-- <div>
        <input v-model="writer" placeholder="글쓴이"/>
        <input v-model="title" placeholder="제목"/>
        <textarea v-model="content" placeholder="내용"/>
        <button @click="index !== undefined ? update() : write()">{{index !== undefined ? '수정' : '작성'}}</button>
    </div> -->
</template>
<script>
import data from '@/data'
import http from '../../../services/http-common.js'

export default {
  name: 'Create',
  data() {
    const id = this.$route.params.contentId;
    return {
      userList: [],
      // name: '',
      // title: '',
      // content: '',
      // pw: "",
      id: id,
      name: id !== undefined ? this.$store.state.userList.b_name : "",
      title: id !== undefined ? this.$store.state.userList.b_title : "",
      content: id !== undefined ? this.$store.state.userList.b_content : "",
      pw: id !== undefined ? "****" : "",
    }
  },
  methods: {
    addUser() {
      if (!this.name) {
        alert("작성자를 입력해 주세요");
      } else if (!this.title) {
        alert("제목을 입력해 주세요");
      } else if (!this.content) {
        alert("내용을 입력해 주세요");
      } else if (!this.pw) {
        alert("비밀번호를 입력해 주세요");
      } else {
        this.$store.commit('ADD_INFO',{
          name: this.name,
          title: this.title,
          content: this.content,
          pw: this.pw
        });
        this.$store.dispatch('addUser');
        this.$router.push({
        path: '/read'
      })
      }
    },
    fnList() {
      this.$router.push({
        path: '/read'
      })
    },
    update() {
      if (!this.name) {
        alert("글쓴이를 입력해 주세요");
      } else if (!this.title) {
        alert("제목을 입력해 주세요");
      } else if (!this.content) {
        alert("내용을 입력해 주세요");
      } else if (!this.pw) {
        alert("비밀번호를 입력해 주세요");
      } else {
        this.$store.commit('UPDATE_INFO', {
          name: this.name,
          title: this.title,
          content: this.content,
          pw: this.pw
        });
        this.$store.dispatch('updateUser', $store.state.userList.b_id);
      }
    }
    },
    created() {
      const id = this.$route.params.contentId;
      this.$store.dispatch('readUserOne', id)
    }
  }
</script>

<style scoped>
.tbAdd {
  border-top: 1px solid #888;
}

.tbAdd th {
  border-bottom: 1px solid #eee;
  padding: 5px 0;
  color: #43b984;
}

.tbAdd td {
  border-bottom: 1px solid #eee;
  padding: 5px 0;
}

.tbAdd td {
  padding: 10px 10px;
  box-sizing: border-box;
  border-left: 1px solid #eee;
}

.tbAdd td input {
  width: 100%;
  min-height: 30px;
  box-sizing: border-box;
  padding: 0 10px;
}

.tbAdd td textarea {
  width: 100%;
  min-height: 300px;
  padding: 10px;
  box-sizing: border-box;
}

.btnWrap {
  text-align: center;
  margin: 20px 0 0 0;
}

.btnWrap a {
  margin: 0 10px;
  display: inline-block;
}

.btnAdd {
  background: #43b984
}

.btnDelete {
  background: #f00;
}
</style>
