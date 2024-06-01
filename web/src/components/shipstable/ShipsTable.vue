<template>
    <el-card class="box-card">
        <el-table
            ref="shipsTable"
            :data="ships"
            highlight-current-row
            @current-change="selectRow"
            style="width: 100%"
        >
            <el-table-column type="index" width="50"> </el-table-column>
            <el-table-column property="name" label="Наименование">
            </el-table-column>
            <el-table-column property="subclass" label="Подкласс">
            </el-table-column>
            <el-table-column
                property="engineResource"
                label="Установленный полный ресурс двигателя, ч"
            >
            </el-table-column>
            <el-table-column
                property="annualPassageRate"
                label="Годовая норма, ч"
                width="150"
            >
            </el-table-column>
        </el-table>
    </el-card>
</template>

<script src="./ShipsTable.ts" lang="ts"></script>

<style lang="scss" scoped>
.box-card {
    width: 60%;
}
::v-deep {
    .el-table__header-wrapper th {
        font-size: 13px;
    }
    .el-table .cell {
        word-break: break-word;
    }
}
</style>
