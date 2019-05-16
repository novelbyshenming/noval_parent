namespace java com.yc.thrift.generated
namespace py py.com.yc.thrift.generated

typedef i16 short
typedef i32 int
typedef i16 long
typedef bool boolean
typedef string String

struct NovalChapterContext{

     1: optional String novalName,
     2: optional String novalChapterName,
     3: optional String type ,
     4: optional String context
     5: optional String lastChapter,
     6: optional String nextChapter;
 }

struct NovalChapter{

   1: optional String novalChapterName,
   2: optional String novalChapterUrl;
}

service NovalService{

    /*根据 章节的url 来动态爬取 小说内容*/
    NovalChapterContext getNovalChapterContextByChapterUrl(1:required String chapterUrl);
    /*根据  小说的url 来动态爬取 小说章节信息和url */
    list<NovalChapter> getNovalChapterListByNovalUrl(1:required String novalUrl);
}