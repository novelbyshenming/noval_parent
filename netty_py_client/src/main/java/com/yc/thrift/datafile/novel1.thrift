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


service NovalService{

    /*根据 章节的url 来动态爬取 小说内容*/
    NovalChapterContext getNovalChapterContextByChapterUrl(1:required String chapterUrl);
}