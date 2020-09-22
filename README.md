# cxz_spark_lib
add jar ./utils-2.0.jar;
create temporary function CompanyType as "com.custom.utils.CompanyRecognize";
create temporary function EditDistance as "com.custom.utils.EditDistance";
create temporary function MatchPeopleName as "com.custom.utils.MatchPeopleName";
create temporary function GetHashId as "com.custom.utils.GetHashId";

