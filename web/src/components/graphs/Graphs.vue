<template>
    <el-card class="box-card">
        <engine-operating />
        <engine-resource-remaining />
        <annual-norm-exceeding />
        <total-norm-exceeding />
    </el-card>
</template>

<script src="./Graphs.ts" lang="ts"></script>

<style lang="scss" scoped>
.box-card {
    width: 100%;
    height: 100%;
    ::v-deep {
        .el-card__body {
            height: 100%;
            box-sizing: border-box;
            display: flex;
        }
    }
}
</style>
