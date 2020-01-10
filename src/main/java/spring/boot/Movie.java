//package spring.boot;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//public class Movie {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "movie_id")
//    private Integer Id;
//
//    @Version
//    private Integer version;
//
//    private String movieTitle;
//
//    @ManyToMany(fetch =FetchType.EAGER)
//    private List<ProductionCompany> productionCompanyList;
//
//    public Movie() {}
//    public Movie(String movieTitle){
//        this.setMovieTitle(movieTitle);
//    }
//
//    public Integer getId() {
//        return Id;
//    }
//    public void setId(Integer id) {
//        Id = id;
//    }
//
//    public Integer getVersion() {
//        return version;
//    }
//    public void setVersion(Integer version) {
//        this.version = version;
//    }
//
//    public String getMovieTitle() {
//        return movieTitle;
//    }
//    public void setMovieTitle(String movieTitle) {
//        this.movieTitle = movieTitle;
//    }
//
//    public List<ProductionCompany> getProductionCompanyList() {
//        return productionCompanyList;
//    }
//    public void setProductionCompanyList(List<ProductionCompany> productionCompanyList) {
//        this.productionCompanyList = productionCompanyList;
//    }
//}
