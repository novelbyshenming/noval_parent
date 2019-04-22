namespace java thrift.generated
namespace py py.thrift.generated

typedef i16 short
typedef i32 int
typedef i16 long
typedef bool boolean
typedef string String

struct NovalChapter{

    1: optional String novalName,
    2: optional String novalChapterName,
    3: optional String type ,
    4: optional String context
    5: optional String lastChapter,
    6: optional String nextChapter;
}


service NovalChapterService{

    NovalChapter getNovalChapterContextByChapterUrl(1:required String url);
}