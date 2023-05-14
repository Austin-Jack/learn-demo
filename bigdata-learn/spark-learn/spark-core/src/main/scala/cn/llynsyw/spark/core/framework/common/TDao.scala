package cn.llynsyw.spark.core.framework.common

import cn.llynsyw.spark.core.framework.util.EnvUtil
import org.apache.spark.rdd.RDD


trait TDao {

    def readFile(path:String): RDD[String] = {
        EnvUtil.take().textFile(path)
    }
}
