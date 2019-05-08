namespace java thrift.generated
namespace py py.thrift.generated

typedef i16 short
typedef i32 int
typedef i16 long
typedef bool boolean
typedef string String

struct NovelChapterContext{

     1: optional String novelName,
     2: optional String novelChapterName,
     3: optional String type ,
     4: optional String context,
     5: optional String lastChapter,
     6: optional String nextChapter;
 }

 struct Novel{
    1: optional String novelName,
    2: optional String introduction,
    3: optional String author,
    4: optional String type,
    5: optional String image;
    6: optional list<NovelChapter> novelChaperList;
 }

struct NovelChapter{

   1: optional String novelChapterName,
   2: optional String novelChapterUrl;
}

service NovelService{

    /*根据 章节的url 来动态爬取 小说内容   用于构建小说页面     */
    NovelChapterContext getNovelChapterContextByChapterUrl(1:required String chapterUrl);
    /*根据  小说的url 来动态爬取 小说章节信息和url    */
    Novel getNovelChapterListByNovelUrl(1:required String novelUrl);
}