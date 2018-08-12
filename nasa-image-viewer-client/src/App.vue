<template>
  <div id="app">
    <el-container>
      <SideMenu/>
      <el-container>
        <el-header height="84px">
          <h1>Mars Rover Photos</h1>
        </el-header>
        <el-main>
          <PhotoTable/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
  import SideMenu from './components/SideMenu'
  import PhotoTable from './components/PhotoTable'
  export default {
    components: {
      SideMenu,
      PhotoTable
    }
  }
</script>

<style>
  .el-header {
    font-size: 2em;
    padding-left: 0;
  }

  .el-aside {
    text-align: center;
  }

  /* .el-main {
    color: #333;
    min-height: 100vh;
  } */

  body {
    /* min-height: 300vh; */
    font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
  }

  body > .el-container {
    margin-bottom: 40px;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
</style>
