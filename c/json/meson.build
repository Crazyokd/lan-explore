cjson_sources = files('''
    cJSON.c
'''.split())

cjson_inc = include_directories('.')

libcjson = library('cjson',
    sources : cjson_sources,
    # version : luasd_version,
    c_args : ['-fvisibility=hidden', '-DCJSON_API_VISIBILITY'],
    include_directories : [cjson_inc],
    dependencies : [],
    install_rpath : libdir,
    install_dir : libdir,
    install : true)

libcjson_dep = declare_dependency(
    link_with : libcjson,
    include_directories : [],
    dependencies : [])
