<template>
    <el-card class="box-card">
        <engine-operating :chart-data="engineOperating" />
        <engine-resource-remaining :chart-data="engineResourceRemaining" />
        <annual-norm-exceeding :chart-data="annualNormExceeding" />
        <total-norm-exceeding :chart-data="totalNormExceeding" />
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
