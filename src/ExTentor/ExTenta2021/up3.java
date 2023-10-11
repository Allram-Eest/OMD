package ExTentor.ExTenta2021;




class DirectoryHandler {

    public void showSystemConfig(FileSystem fileSystem) {
        String content = fileSystem.root() //Optional<Directory>
                                    .flatmap((d) -> d.into("etc")) //Optional<Directory>
                                    .flatmap((d) -> d.into("systemd"))
                                    .flatmap((d) -> into("systemd"))
                                    .flatmap((d) -> d.into("system"))
                                    .flatmap((d) -> d.open("conf"))
                                    .flatmap((f) -> f.contents())
                                    .orElse(""); 
    }
}