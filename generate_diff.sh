#!/bin/bash

# 取得當前的時間戳
timestamp=$(date +"%Y%m%d%H%M%S")

# 設定 changeLogFile 路徑
changeLogFile="src/main/resources/db/changelog/db.changelog-master.yaml"

# 動態生成 diffChangeLogFile 檔案名稱
diffChangeLogFile="src/main/resources/db/changelog/diff/db.changelog-diff-$timestamp.yaml"

# 執行 Maven Liquibase diff 並傳遞動態生成的檔案名稱
mvn liquibase:diff -Dliquibase.changeLogFile=$changeLogFile -Dliquibase.diffChangeLogFile=$diffChangeLogFile

# 印出生成的檔案名稱，供參考
echo "Generated diffChangeLogFile: $diffChangeLogFile"
